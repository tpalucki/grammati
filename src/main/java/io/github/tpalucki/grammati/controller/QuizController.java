package io.github.tpalucki.grammati.controller;

import io.github.tpalucki.grammati.configuration.AppConfig;
import io.github.tpalucki.grammati.domain.Question;
import io.github.tpalucki.grammati.domain.Quiz;
import io.github.tpalucki.grammati.exception.QuizNotFoundException;
import io.github.tpalucki.grammati.repository.ExerciseRepository;
import io.github.tpalucki.grammati.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * GET /quiz/quizId
 * Ma zwrócić pierwsze pytanie dla danego quizu
 * <p>
 * POST /quiz/quizId
 * Ma przetworzyć odpowiedź dla danego quizy oraz wyświetlić kolejne pytanie
 */

@Controller
@RequiredArgsConstructor
@Slf4j
public class QuizController {

    private final AppConfig appConfig;
    private final QuizRepository quizRepository;
    private final ExerciseRepository questionRepository;

    @GetMapping("/quiz/{quizReference}")
    public String showQuestion(@PathVariable("quizReference") String quizReference, Model model) throws QuizNotFoundException {
        log.info("GET /quiz/" + quizReference);
        /*
         * 1. Get quiz
         * 2. Get next question for quiz
         * 3. Print question
         */

        Quiz quiz = quizRepository.findQuizBySessionId(quizReference);

        if (quiz == null) {
            throw new QuizNotFoundException("Cannot find quiz with id: " + quizReference);
        }

        Question question = questionRepository.findById(quiz.nextExerciseId()).orElseThrow(() -> new IllegalArgumentException("Question not exists"));

        model.addAttribute("question", question);
        model.addAttribute("title", appConfig.getAppTitle());

        return "quizView";
    }

    @ExceptionHandler(QuizNotFoundException.class)
    public String quizNotFound(QuizNotFoundException e, Model model) {
        log.info("Exception: " + e.getMessage());

        model.addAttribute("message", e.getMessage());
        model.addAttribute("title", appConfig.getAppTitle());

        return "message";
    }
}
