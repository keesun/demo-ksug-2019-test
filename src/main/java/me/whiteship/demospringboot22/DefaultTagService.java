package me.whiteship.demospringboot22;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultTagService implements TagService {

    final TagRepository tagRepository;

    @Override
    @Transactional
    public void increaseCount(StudyTag studyTag) {
        Optional<StudyTag> existingTag = tagRepository.findByName(studyTag.getName());
        if (existingTag.isEmpty()) {
            studyTag = tagRepository.save(studyTag);
        }
        studyTag.increaseCount();
    }
}
