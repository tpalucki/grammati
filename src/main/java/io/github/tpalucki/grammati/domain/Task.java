package io.github.tpalucki.grammati.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "task")
@Data
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private String question;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Quiz quiz;

}
