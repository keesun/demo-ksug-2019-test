package me.whiteship.ksug2019.study;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class StudyController {

    private final StudyKeywordRepository repository;
    private final MemberServiceClient memberServiceClient;

    @GetMapping("/study/keyword/{username}/{keyword}")
    public StudyKeyword add(@PathVariable String username, @PathVariable String keyword) {
        memberServiceClient.validate(username);
        StudyKeyword studyKeyword = StudyKeyword.builder().username(username).keyword(keyword).build();
        Optional<StudyKeyword> existingOne = repository.findOne(Example.of(studyKeyword, ExampleMatcher.matchingAll().withIgnoreCase()));
        return existingOne.orElseGet(() -> repository.save(studyKeyword));
    }

    @GetMapping("/study/view/data")
    public List<TagCloudData> tagCloudData() {
        return repository.getTagCloudData();

    }
}
