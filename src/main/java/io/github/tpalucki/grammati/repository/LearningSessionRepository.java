package io.github.tpalucki.grammati.repository;

import io.github.tpalucki.grammati.domain.LearningSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningSessionRepository extends CrudRepository<LearningSession, Long> {

    LearningSession findBySessionHash(String sessionHash);
}
