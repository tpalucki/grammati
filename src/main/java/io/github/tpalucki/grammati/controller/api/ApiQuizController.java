package io.github.tpalucki.grammati.controller.api;

import io.github.tpalucki.grammati.domain.Quiz;
import io.github.tpalucki.grammati.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
@RequiredArgsConstructor
public class ApiQuizController {

    private final QuizRepository quizRepository;

    @GetMapping("/quiz/{id}")
    public Quiz getQuiz(@PathVariable String id) {
        log.info("GET /api/v1/quiz/{}", id);

        Quiz quiz = quizRepository.findQuizBySessionId(id);
        return quiz;
    }
}
