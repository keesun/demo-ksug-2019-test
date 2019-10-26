package me.whiteship.demospringboot22;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("스터디 테스트")
public class StudyTests {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each");
    }

    @Test
    @DisplayName("스터디 만들기")
    void createNewStudy() {
        Study study = Study.builder()
                .title("JUnit 5")
                .maxNumberOfParticipant(10)
                .build();

        assertNotNull(study);

        assertAll(
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), "New study's status should be DRAFT"),
                () -> assertEquals("JUnit 5", study.getTitle(), "Titles are not equals"),
                () -> assertEquals(10, study.getMaxNumberOfParticipant(), "MaxNumberOfParticipants are not equals"));
    }

    @Test
    @Disabled
    @DisplayName("스터디 만들기 에러: 최대 참석자 수가 음수인 경우")
    void createNewStudyError_as_MaxNumberOfParticipant_is_minus() {
        assertThrows(IllegalArgumentException.class, () -> Study.builder()
            .title("JUnit 5")
            .maxNumberOfParticipant(-10)
            .build());
    }

}
