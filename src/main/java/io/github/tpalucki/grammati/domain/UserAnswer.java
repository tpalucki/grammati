package io.github.tpalucki.grammati.domain;

import io.github.tpalucki.grammati.domain.dto.AnswerDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserAnswer {

  @Id @GeneratedValue private Long id;

  Long userId;
  Long questionId;
  Long answerId;
  String answerText;

  public UserAnswer(Long userId, AnswerDto answerDto) {
    this.userId = userId;
    this.questionId = answerDto.getQuestionReference();
    this.answerId = answerDto.getAnswerId();
    this.answerText = answerDto.getAnswer();
  }
}
