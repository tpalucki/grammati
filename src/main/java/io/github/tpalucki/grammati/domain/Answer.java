package io.github.tpalucki.grammati.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude="question")
@ToString
@Entity
public class Answer {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Question question;

    private String answerText;

    private boolean correct;
}
