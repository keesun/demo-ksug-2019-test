package me.whiteship.demospringboot22;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter @Setter
public class Study {

    @Id @GeneratedValue
    private Long id;
    private String title;
    private int maxNumberOfParticipant;
    private StudyStatus status;
    private LocalDateTime created;

    @ManyToMany
    private Set<StudyTag> studyTags;

    public Study(String title, int maxNumberOfParticipant, Set<StudyTag> studyTags) {
        this.status = StudyStatus.DRAFT;
        this.title = title;
        this.studyTags = studyTags;
        this.maxNumberOfParticipant = maxNumberOfParticipant;
    }

    public static StudyBuilder builder() {
        return new StudyBuilder();
    }

}
