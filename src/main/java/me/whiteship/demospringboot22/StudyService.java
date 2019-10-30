package me.whiteship.demospringboot22;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudyService {

    final StudyRepository studyRepository;
    final TagService tagService;

    public Study registerNewStudy(Study study) {
        Study newStudy = studyRepository.save(study);
        newStudy.getTags().forEach(tagService::increaseCount);
        return newStudy;
    }

}
