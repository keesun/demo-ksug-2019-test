package me.whiteship.demospringboot22;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface TagRepository extends JpaRepository<StudyTag, Integer> {
    Optional<StudyTag> findByName(String name);
}
