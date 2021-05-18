package io.github.tpalucki.grammati.controller;

import io.github.tpalucki.grammati.domain.Quiz;
import io.github.tpalucki.grammati.domain.UserAnswer;
import io.github.tpalucki.grammati.repository.AnswerRepository;
import io.github.tpalucki.grammati.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class QuizResource {

    private final QuizRepository quizRepository;
    private final AnswerRepository answerRepository;

    // TODO plural nouns in paths
    // TODO api version in paths
    // TODO validation of the post body

    @GetMapping(path = "/api/quiz")
    @ResponseBody
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @GetMapping(path = "/api/quiz/{id}")
    @ResponseBody
    public Quiz getQuizBySessionId(@PathVariable String id) {
        return quizRepository.findBySessionId(id);
    }

    @PostMapping(path = "/api/answer", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserAnswer handleAnswer(@RequestBody UserAnswer answer) {
        return answerRepository.save(answer);
    }
}
