package io.github.tpalucki.grammati.repository;

import io.github.tpalucki.grammati.domain.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {

    Quiz findQuizBySessionId(String sessionId);
}
