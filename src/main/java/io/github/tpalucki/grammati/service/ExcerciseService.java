package io.github.tpalucki.grammati.service;

import io.github.tpalucki.grammati.domain.Excercise;
import io.github.tpalucki.grammati.repository.ExcerciseRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ExcerciseService {

    private final ExcerciseRespository excerciseRespository;

    public Optional<Excercise> getExcerciseForId(String id) {
        return Optional.of(excerciseRespository.findAll().iterator().next());
    }

    public Optional<Excercise> getRandomExcercise() {
        return StreamSupport.stream(excerciseRespository.findAll().spliterator(), false).findAny();
    }
}
