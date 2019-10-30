package me.whiteship.demospringboot22;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
public class Study {

    @Id @GeneratedValue
    private Long id;
    private String title;
    private int maxNumberOfParticipant;
    private StudyStatus status;

    @ManyToMany
    private Set<Tag> tags;

    public Study(String title, int maxNumberOfParticipant) {
        this.status = StudyStatus.DRAFT;
        this.title = title;
        this.maxNumberOfParticipant = maxNumberOfParticipant;
    }

    public static StudyBuilder builder() {
        return new StudyBuilder();
    }

}
