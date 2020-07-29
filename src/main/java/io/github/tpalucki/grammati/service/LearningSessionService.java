package io.github.tpalucki.grammati.service;

import io.github.tpalucki.grammati.domain.LearningSession;
import io.github.tpalucki.grammati.repository.LearningSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LearningSessionService {

    private final LearningSessionRepository repository;

    public void update(LearningSession learningSession) {
        repository.save(learningSession);
    }

    public LearningSession getLearningSession(String sessionId) {
        return repository.findBySessionHash(sessionId);
    }
}
