package me.whiteship.ksug2019.member;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id")
@AllArgsConstructor @NoArgsConstructor @Builder
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;


}
