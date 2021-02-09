package io.github.tpalucki.grammati.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quiz")
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quizId;
    private String sessionId;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.EAGER)
    private List<Question> questions = new ArrayList<>();
}
