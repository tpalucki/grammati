package io.github.tpalucki.grammati.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Excercise {

    @Id
    @GeneratedValue
    private Long id;
    private String question;
    @ElementCollection
    private List<String> answers;
    private String tip;

}
