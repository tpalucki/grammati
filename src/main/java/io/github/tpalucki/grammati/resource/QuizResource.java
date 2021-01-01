package io.github.tpalucki.grammati.resource;

import io.github.tpalucki.grammati.domain.Quiz;
import io.github.tpalucki.grammati.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class QuizResource {

    private final QuizRepository quizRepository;

    @GetMapping(path = "/api/quiz")
    @ResponseBody()
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

}
