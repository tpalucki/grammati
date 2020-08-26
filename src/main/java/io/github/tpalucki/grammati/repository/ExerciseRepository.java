package io.github.tpalucki.grammati.repository;

import io.github.tpalucki.grammati.domain.Question;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Question, Long> {

}
