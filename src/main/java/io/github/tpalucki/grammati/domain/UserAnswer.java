package io.github.tpalucki.grammati.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_answer")
@Data
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userAnswerId;

    Long quizId;
    String sessionId;

    @Embedded
    UserAnswerQuestion question;

    @Embedded
    UserAnswerAnswer answer;

}
