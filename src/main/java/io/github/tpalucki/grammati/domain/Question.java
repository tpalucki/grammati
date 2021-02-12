package io.github.tpalucki.grammati.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

import static java.util.Objects.nonNull;

@Entity
@Table(name = "question")
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId;
    private String question;

    @ManyToMany(mappedBy = "questions")
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Quiz> quizzes;

    @OneToMany(
            mappedBy = "question",
            fetch = FetchType.EAGER
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Answer> answers;

    @JsonIgnore
    private String tipEng;
    @JsonIgnore
    private String tipPl;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTip() {
        if (nonNull(tipEng)) {
            return tipEng;
        } else {
            return tipPl;
        }

    }
}
