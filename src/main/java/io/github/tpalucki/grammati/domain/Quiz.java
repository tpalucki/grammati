package io.github.tpalucki.grammati.domain;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

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
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> exercises = new LinkedList<>();

    public Long nextExerciseId() {
        return exercises.isEmpty() ? null : exercises.remove(0);
    }

}
