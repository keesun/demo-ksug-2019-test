package me.whiteship.demospringboot22;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class StudyServiceTest {

    @Test
    public void di() {
        StudyRepository studyRepository = mock(StudyRepository.class);
        TagService tagService = mock(TagService.class);

        StudyService studyService = new StudyService(studyRepository, tagService);
        assertNotNull(studyService);
        assertNotNull(studyRepository);
        assertNotNull(tagService);
    }

}