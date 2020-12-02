package io.github.tpalucki.grammati.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quiz")
@Data
public class Quiz {

    @Id
    @GeneratedValue
    private Long id;
    private String reference;

}
