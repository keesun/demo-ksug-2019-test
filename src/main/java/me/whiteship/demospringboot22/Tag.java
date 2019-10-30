package me.whiteship.demospringboot22;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Tag {

    @Id @GeneratedValue
    Integer id;

    String name;

    Integer count;

    public void increaseCount() {
        count++;
    }
}
