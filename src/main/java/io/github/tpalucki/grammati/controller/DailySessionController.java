package io.github.tpalucki.grammati.controller;

import io.github.tpalucki.grammati.configuration.AppConfig;
import io.github.tpalucki.grammati.domain.Question;
import io.github.tpalucki.grammati.domain.Quiz;
import io.github.tpalucki.grammati.repository.ExerciseRepository;
import io.github.tpalucki.grammati.service.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
@RequiredArgsConstructor
public class DailySessionController {

    private final QuizService quizService;
    private final ExerciseRepository exerciseRepository;
    private final AppConfig appConfig;

    @GetMapping("/daily")
    public String endpointAvailable(Model model) {
        log.info("GET /daily");
        model.addAttribute("message", "Endpoint available");
        return "message"; // TODO forward to message page
    }

    // mamy zwrocic strone z pierwszym cwiczeniem
    // albo strone z wiadomoscia "NIe ma takiego cwiczenie"
    // albo strone z wiadomoscia "Wykonales juz wszystkie cwiczenia na dzis"
    @GetMapping("/daily/{sessionId}")
    public String getDailySession(@PathVariable("sessionId") String sessionId, Model model) {
        log.info("GET /daily/" + sessionId);

        model.addAttribute("title", appConfig.getAppTitle());

        Quiz quiz = quizService.getLearningSession(sessionId);
//        if (quiz.isCompleted()) {
//            model.addAttribute("message", "You have completed your daily questions");
//            return "message";
//        }

        if (Objects.isNull(quiz)) {
            model.addAttribute("message", "No exercise for you today");
            return "message";
        }

//        List<Long> exercises = quiz.getQuestions();
//
//        Question question1 = exerciseRepository.findById(exercises.get(0)).get();
//        Question question2 = exerciseRepository.findById(exercises.get(1)).get();
//        Question question3 = exerciseRepository.findById(exercises.get(2)).get();
//        Question question4 = exerciseRepository.findById(exercises.get(3)).get();


//        model.addAttribute("question1", question1);
//        model.addAttribute("question2", question2);
//        model.addAttribute("question3", question3);
//        model.addAttribute("question4", question4);


//        ADto quizDto = ADto.builder().questions(List.of(question1, question2, question3, question4)).build();
//        model.addAttribute("questions", List.of(question1, question2, question3, question4));
        model.addAttribute("questions", quiz.getQuestions());

        return "quiz";
    }

    @PostMapping("/daily/{sessionId}")
    public String handleForm(@PathVariable("sessionId") String sessionId, @Validated Question answer, Model model) {
        log.info("POST /daily/{}", sessionId);

        model.addAttribute("message", "Success");

        return "message";
    }
}