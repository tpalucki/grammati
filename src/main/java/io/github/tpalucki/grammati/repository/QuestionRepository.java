package io.github.tpalucki.grammati.repository;

import io.github.tpalucki.grammati.domain.Level;
import io.github.tpalucki.grammati.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByLevelEquals(Level level);
}
