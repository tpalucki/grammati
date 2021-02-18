package io.github.tpalucki.grammati.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "quiz_to_questions")
@Data
public class QuizToQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizToQuestionsId;
    @Column(name = "quiz_id")
    private Long quizId;
    @Column(name = "question_id")
    private Long questionId;
}
