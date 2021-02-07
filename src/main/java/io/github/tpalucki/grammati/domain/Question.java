package io.github.tpalucki.grammati.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question")
@Data
public class Question {

    @Id
    @GeneratedValue
    private Long questionId;
    private String question;

//    @ManyToOne
//    @JoinColumn(name = "quiz_id", nullable = false)
//    private Quiz quiz;

}
