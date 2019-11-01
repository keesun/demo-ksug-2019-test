package me.whiteship.ksug2019.study;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class StudyController {

    private final StudyKeywordRepository repository;
    private final MemberServiceClient memberServiceClient;

    @GetMapping("/study/keyword/{memberId}/{keyword}")
    public StudyKeyword add(@PathVariable Integer memberId, @PathVariable String keyword) {
        memberServiceClient.validate(memberId);
        StudyKeyword studyKeyword = StudyKeyword.builder().memberId(memberId).keyword(keyword).build();
        Optional<StudyKeyword> existingOne = repository.findOne(Example.of(studyKeyword, ExampleMatcher.matchingAll().withIgnoreCase()));
        return existingOne.orElseGet(() -> repository.save(studyKeyword));
    }
}
