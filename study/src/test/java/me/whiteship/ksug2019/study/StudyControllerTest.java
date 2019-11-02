package me.whiteship.ksug2019.study;

import com.palantir.docker.compose.DockerComposeExtension;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Testcontainers
@ContextConfiguration(initializers = StudyControllerTest.Initializer.class)
@TestPropertySource(properties = "app.member-service-root-uri=http://localhost:28081/member/")
class StudyControllerTest {

    @Autowired MockMvc mockMvc;

    @Container
    private static final PostgreSQLContainer keywordDB = (PostgreSQLContainer) new PostgreSQLContainer()
            .withDatabaseName("study-test")
            .withUsername("ksug2019")
            .withPassword("whiteship");

    @RegisterExtension
    public static DockerComposeExtension docker = DockerComposeExtension.builder()
            .file("src/test/resources/docker-compose.yml")
            .build();

    @Test
    @DisplayName("관심 키워드 추가하기")
    public void addKeyword() throws Exception {
        StudyKeyword studyKeyword = StudyKeyword.builder()
                .id(10L)
                .username("test")
                .keyword("Spring")
                .build();

        mockMvc.perform(get("/study/keyword/{username}/{keyword}", studyKeyword.getUsername(), studyKeyword.getKeyword()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.notNullValue()))
                .andExpect(jsonPath("$.keyword", Matchers.equalTo(studyKeyword.getKeyword())))
                .andExpect(jsonPath("$.username", Matchers.equalTo(studyKeyword.getUsername())));
    }

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                "spring.datasource.url=" + keywordDB.getJdbcUrl(),
                "spring.datasource.username=" + keywordDB.getUsername(),
                "spring.datasource.password=" + keywordDB.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

}