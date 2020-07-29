package io.github.tpalucki.grammati.controller;

import io.github.tpalucki.grammati.configuration.AppConfig;
import io.github.tpalucki.grammati.domain.Exercise;
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

    private final ExerciseService exerciseService;
    private final AppConfig appConfig;

    @GetMapping("/exercises/random")
    public String getRandomExercise(Model model) {
        log.info("GET /exercises/random");
        model.addAttribute("title", appConfig.getAppTitle());
        model.addAttribute("exercise", exerciseService.getRandomExercise().get());
        return "exercise";
    }

    @GetMapping("/exercises/{id}")
    public String getExercise(@PathVariable("id") String id, Model model) {
        log.info("GET /exercises/" + id);
        Optional<Exercise> exerciseOptional = exerciseService.getExerciseForId(id);
        if (exerciseOptional.isEmpty()) {
            model.addAttribute("message", "Exercise not found");
            return "error";
        }
        model.addAttribute("title", appConfig.getAppTitle());
        model.addAttribute("exercise", exerciseOptional.get());
        return "exercise";
    }

    @PostMapping("/exercises/{id}")
    public String handleAnswer(@PathVariable("id") @Nullable String id, @Validated Exercise answer, Model model) {
        log.info("POST /exercises/" + id);

        model.addAttribute("title", appConfig.getAppTitle());
        return "exercise";
    }
}
