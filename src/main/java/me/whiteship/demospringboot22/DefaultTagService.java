package me.whiteship.demospringboot22;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultTagService implements TagService {

    final TagRepository tagRepository;

    @Override
    public void increaseCount(Tag tag) {
        tag.increaseCount();
        tagRepository.save(tag);
    }
}
