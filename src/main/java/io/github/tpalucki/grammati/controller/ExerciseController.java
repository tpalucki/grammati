package io.github.tpalucki.grammati.controller;

import io.github.tpalucki.grammati.configuration.AppConfig;
import io.github.tpalucki.grammati.domain.Question;
import io.github.tpalucki.grammati.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService questionService;
    private final AppConfig appConfig;

    // TODO this is not essentiaal for MVP
//    @GetMapping("/questions/random")
//    public String getRandomExercise(Model model) {
//        log.info("GET /exercises/random");
//        model.addAttribute("title", appConfig.getAppTitle());
//        model.addAttribute("exercise", questionService.getRandomExercise().get());
//        return "exercise";
//    }


    @GetMapping("/questions/{id}")
    public String getExercise(@PathVariable("id") String id, Model model) {
        log.info("GET /questions/" + id);
        Optional<Question> questionOptional = questionService.getQuestionForId(id);
        if (questionOptional.isEmpty()) {
            model.addAttribute("message", "Question not found");
            return "error";
        }
        model.addAttribute("title", appConfig.getAppTitle());
        model.addAttribute("exercise", questionOptional.get());
        return "exercise";
    }

    @PostMapping("/questions/{id}")
    public String handleAnswer(@PathVariable("id") @Nullable String id, @Validated Question answer, Model model) {
        log.info("POST /questions/" + id);

        model.addAttribute("title", appConfig.getAppTitle());
        return "exercise";
    }
}
