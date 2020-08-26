package io.github.tpalucki.grammati.configuration;

import io.github.tpalucki.grammati.domain.Question;
import io.github.tpalucki.grammati.domain.Quiz;
import io.github.tpalucki.grammati.repository.ExerciseRepository;
import io.github.tpalucki.grammati.repository.QuizRepository;
import io.github.tpalucki.grammati.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class InitDatabaseRunner implements CommandLineRunner {

    private final SubscriptionRepository subscriptionRepository;
    private final ExerciseRepository exerciseRepository;
    private final QuizRepository quizRepository;

    @Override
    public void run(String... args) {
        Question question = new Question();
        question.setQuestion("She goes/is going to the gym twice a week.");
        question.setAnswers(List.of("goes", "is going"));
        question.setTip("We use the present simple for things that we do regularly.");
        exerciseRepository.save(question);

        question = new Question();
        question.setQuestion("Water boils/is boiling at 100o C.");
        question.setAnswers(List.of("boils", "is boiling"));
        question.setTip("We use the present simple for things that are true in general.");
        exerciseRepository.save(question);

        question = new Question();
        question.setQuestion("He works/is working in a bank.");
        question.setAnswers(List.of("works", "is working"));
        question.setTip("We use the present simple for situations which are permanent.");
        exerciseRepository.save(question);

        question = new Question();
        question.setQuestion("I want/’m wanting to go home.");
        question.setAnswers(List.of("want", "'m wanting"));
        question.setTip("We use the present simple with stative verbs.");
        exerciseRepository.save(question);

        for (Question item : exerciseRepository.findAll()) {
            log.info(item.toString());
        }

        Quiz quiz = Quiz.builder().sessionId("a").exercises(List.of(1l, 2l, 3l, 4l)).build();
        log.info(quizRepository.save(quiz).toString());
    }
}
