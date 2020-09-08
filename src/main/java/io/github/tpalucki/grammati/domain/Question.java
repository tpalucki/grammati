package io.github.tpalucki.grammati.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue
    private Long id;
    private String question;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> answers;
    private String tip;

    public String formattedTip() {
        return "Tip: " + tip;
    }
}
