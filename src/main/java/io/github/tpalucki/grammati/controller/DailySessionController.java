package io.github.tpalucki.grammati.controller;

import io.github.tpalucki.grammati.configuration.AppConfig;
import io.github.tpalucki.grammati.domain.LearningSession;
import io.github.tpalucki.grammati.service.LearningSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Objects;

@Slf4j
@Controller
@RequiredArgsConstructor
public class DailySessionController {

    private final LearningSessionService dailySessionService;
    private final AppConfig appConfig;

    // mamy zwrocic strone z pierwszym cwiczeniem
    // albo strone z wiadomoscia "NIe ma takiego cwiczenie"
    // albo strone z wiadomoscia "Wykonales juz wszystkie cwiczenia na dzis"
    @GetMapping("/daily/{sessionId}")
    public String getDailySession(@PathVariable("sessionId") String sessionId, Model model) {
        log.info("GET /daily/" + sessionId);

        model.addAttribute("title", appConfig.getAppTitle());

        LearningSession learningSession = dailySessionService.getLearningSession(sessionId);
        if (learningSession.isCompleted()) {
            model.addAttribute("message", "You have completed your daily exercises");
            return "infoPage";
        }

        if (Objects.isNull(learningSession)) {
            model.addAttribute("message", "No exercise for you today");
            return "infoPage";
        }

        Long exerciseId = learningSession.nextExerciseId();
        dailySessionService.update(learningSession);
        return "forward:/exercises/" + exerciseId;
    }
}
