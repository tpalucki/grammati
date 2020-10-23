package io.github.tpalucki.grammati.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = "question")
@Entity
@Table(name = "ANSWER")
public class Answer {

  @Id @GeneratedValue private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  private Question question;

  private String answerText;

  private boolean correct;
}
