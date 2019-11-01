package me.whiteship.ksug2019.study;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class StudyControllerTest {

    @Autowired MockMvc mockMvc;

    @MockBean MemberServiceClient memberServiceClient;
    @MockBean StudyKeywordRepository repository;

    @Test
    @DisplayName("관심 키워드 추가하기")
    public void addKeyword() throws Exception {
        StudyKeyword studyKeyword = StudyKeyword.builder()
                .id(10L)
                .memberId(2)
                .keyword("Spring")
                .build();

        given(repository.save(any())).willReturn(studyKeyword);

        mockMvc.perform(get("/study/keyword/{memberId}/{keyword}", studyKeyword.getMemberId(), studyKeyword.getKeyword()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.notNullValue()))
                .andExpect(jsonPath("$.keyword", Matchers.equalTo(studyKeyword.getKeyword())))
                .andExpect(jsonPath("$.memberId", Matchers.equalTo(studyKeyword.getMemberId())));
    }

}