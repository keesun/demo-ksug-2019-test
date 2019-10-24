package me.whiteship.demospringboot22;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("스터디 테스트")
public class StudyTests {

    @Test
    @DisplayName("스터디 만들기")
    void createNewStudy() {
        Study study = Study.builder()
                .title("JUnit 5")
                .maxNumberOfParticipant(10)
                .build();

        assertNotNull(study);

        assertEquals(study.getStatus(), StudyStatus.DRAFT);
        assertEquals(study.getTitle(), "JUnit 5");
        assertEquals(study.getMaxNumberOfParticipant(), 9);
    }
}
