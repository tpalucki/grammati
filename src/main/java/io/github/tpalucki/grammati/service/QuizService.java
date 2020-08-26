package io.github.tpalucki.grammati.service;

import io.github.tpalucki.grammati.domain.Quiz;
import io.github.tpalucki.grammati.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuizService {

    private final QuizRepository repository;

    public void update(Quiz quiz) {
        repository.save(quiz);
    }

    public Quiz getLearningSession(String sessionId) {
        return repository.findQuizBySessionId(sessionId);
    }
}
