package me.whiteship.demospringboot22;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class StudyService {

    final StudyRepository studyRepository;
    final TagService tagService;

    @Transactional
    public Study registerNewStudy(Study study) {
        study.setCreated(LocalDateTime.now());
        Study newStudy = studyRepository.save(study);
        newStudy.getStudyTags().forEach(tagService::increaseCount);
        return newStudy;
    }

}
