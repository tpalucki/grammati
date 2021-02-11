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

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "quiz_to_questions",
            joinColumns = {@JoinColumn(name = "quiz_id")},
            inverseJoinColumns = {@JoinColumn(name = "question_id")}
    )
    private List<Question> questions = new ArrayList<>();
}
