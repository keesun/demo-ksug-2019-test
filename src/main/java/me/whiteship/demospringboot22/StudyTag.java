package me.whiteship.demospringboot22;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class StudyTag {

    @Id @GeneratedValue
    Integer id;

    String name;

    Integer count;

    public StudyTag(String name) {
        this.name = name;
    }

    public void increaseCount() {
        count++;
    }
}
