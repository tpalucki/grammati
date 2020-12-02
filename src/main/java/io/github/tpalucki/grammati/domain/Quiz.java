package io.github.tpalucki.grammati.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "quiz")
@Data
public class Quiz {

    @Id
    @GeneratedValue
    private Long quizId;
    private String reference;

    @OneToMany
    private Set<Task> tasks = new HashSet<>();
}
