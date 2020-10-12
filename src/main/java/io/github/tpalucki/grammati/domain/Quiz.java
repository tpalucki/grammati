package io.github.tpalucki.grammati.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String sessionId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quiz")
//    @ElementCollection(fetch = FetchType.LAZY, )
    private Set<Question> questions = new HashSet<>();

//    public Long nextExerciseId() {
//        return questions.isEmpty() ? null : questions.remove(0);
//    }

}
