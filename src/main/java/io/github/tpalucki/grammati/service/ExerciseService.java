package io.github.tpalucki.grammati.service;

import io.github.tpalucki.grammati.domain.Exercise;
import io.github.tpalucki.grammati.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public Optional<Exercise> getExerciseForId(String id) {
        return Optional.of(exerciseRepository.findAll().iterator().next());
    }

    public Optional<Exercise> getRandomExercise() {
        return StreamSupport.stream(exerciseRepository.findAll().spliterator(), false).findAny();
    }
}
