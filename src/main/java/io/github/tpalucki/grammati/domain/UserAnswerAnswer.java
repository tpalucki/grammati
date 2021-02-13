package io.github.tpalucki.grammati.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class UserAnswerAnswer {

    Long answerId;
    String answerText;
    boolean correct;

}
