package io.github.tpalucki.grammati.service;

import io.github.tpalucki.grammati.domain.Question;
import io.github.tpalucki.grammati.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public Optional<Question> getQuestionForId(String id) {
        return Optional.of(exerciseRepository.findAll().iterator().next());
    }

    public Optional<Question> getRandomExercise() {
        return StreamSupport.stream(exerciseRepository.findAll().spliterator(), false).findAny();
    }
}
