package io.github.tpalucki.grammati.controller;

import io.github.tpalucki.grammati.configuration.AppConfig;
import io.github.tpalucki.grammati.domain.Excercise;
import io.github.tpalucki.grammati.service.ExcerciseService;
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
public class ExcerciseController {

    private final ExcerciseService excerciseService;
    private final AppConfig appConfig;

    @GetMapping("/excercises/random")
    public String getRandomExcercise(Model model) {
        model.addAttribute("title", appConfig.getAppTitle());
        model.addAttribute("excercise", excerciseService.getRandomExcercise().get());
        return "excercise";
    }

    @GetMapping("/excercises/{id}")
    public String getExcercise(@PathVariable("id") String id, Model model) {
        Optional<Excercise> excerciseOptional = excerciseService.getExcerciseForId(id);
        if (excerciseOptional.isEmpty()) {
            model.addAttribute("message", "Excercise not found");
            return "error";
        }
        model.addAttribute("title", appConfig.getAppTitle());
        model.addAttribute("excercise", excerciseOptional.get());
        return "excercise";
    }

    @PostMapping(value = {"/excercises/random", "/excercises/{id}"})
    public String handleAnswer(@PathVariable("id") @Nullable String id, @Validated Excercise answer, Model model) {
        // TODO refactor
//        Excercise excercise = new Excercise();
//        excercise.setQuestion("Is it sth new?");
//        excercise.setAnswers(List.of("First", "Second", "Third", "Fourth"));
//
//        model.addAttribute("excercise", excercise);
        model.addAttribute("title", appConfig.getAppTitle());
        return "excercise";
    }
}
