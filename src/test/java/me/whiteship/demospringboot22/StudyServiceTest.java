package me.whiteship.demospringboot22;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StudyServiceTest {

    @Test
    public void registerNewStudy() {
        StudyRepository studyRepository = mock(StudyRepository.class);
        TagService tagService = mock(TagService.class);
        StudyService studyService = new StudyService(studyRepository, tagService);
        Study newStudy = Study.builder()
                .title("Mockito")
                .maxNumberOfParticipant(5)
                .addTag(new StudyTag("Test"))
                .addTag(new StudyTag("Java"))
                .build();

        when(studyRepository.save(newStudy)).thenReturn(newStudy);

        Study mockitoStudy = studyService.registerNewStudy(newStudy);

        assertEquals("Mockito", mockitoStudy.getTitle());
        assertNotNull(mockitoStudy.getCreated());
    }

}