package io.github.tpalucki.grammati.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    private String question;

//    @ElementCollection(fetch = FetchType.EAGER)
    @OneToMany(fetch = FetchType.LAZY)
    private Set<QuestionAnswer> answers = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Quiz quiz;

    private String tip;

    public String formattedTip() {
        return "Tip: " + tip;
    }
}
