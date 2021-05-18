package io.github.tpalucki.grammati.controller;

import io.github.tpalucki.grammati.service.DailyQuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DailyQuizResource {

    private final DailyQuizService quizService;

    @GetMapping("/api/daily")
    @ResponseStatus(HttpStatus.OK)
    public void processDailyQuiz() {
        quizService.processDailyQuiz();
    }
}
