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
public class LearningSession {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String sessionHash;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> exercises = new LinkedList<>();

    public Long nextExerciseId() {
        return exercises.remove(0);
    }

    public boolean isCompleted() {
        return exercises.isEmpty();
    }
}
