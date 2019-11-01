package me.whiteship.ksug2019.study;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id")
@AllArgsConstructor @NoArgsConstructor @Builder
public class StudyKeyword {

    @Id @GeneratedValue
    private Long id;

    private String keyword;

    private Integer memberId;

}
