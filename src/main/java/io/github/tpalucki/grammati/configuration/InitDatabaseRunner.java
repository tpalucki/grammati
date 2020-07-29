package io.github.tpalucki.grammati.configuration;

import io.github.tpalucki.grammati.domain.Exercise;
import io.github.tpalucki.grammati.domain.LearningSession;
import io.github.tpalucki.grammati.repository.ExerciseRepository;
import io.github.tpalucki.grammati.repository.LearningSessionRepository;
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
    private final LearningSessionRepository learningSessionRepository;

    @Override
    public void run(String... args) {
        Exercise exercise = new Exercise();
        exercise.setQuestion("She goes/is going to the gym twice a week.");
        exercise.setAnswers(List.of("goes", "is going"));
        exercise.setTip("We use the present simple for things that we do regularly.");
        exerciseRepository.save(exercise);

        exercise = new Exercise();
        exercise.setQuestion("Water boils/is boiling at 100o C.");
        exercise.setAnswers(List.of("boils", "is boiling"));
        exercise.setTip("We use the present simple for things that are true in general.");
        exerciseRepository.save(exercise);

        exercise = new Exercise();
        exercise.setQuestion("He works/is working in a bank.");
        exercise.setAnswers(List.of("works", "is working"));
        exercise.setTip("We use the present simple for situations which are permanent.");
        exerciseRepository.save(exercise);

        exercise = new Exercise();
        exercise.setQuestion("I want/’m wanting to go home.");
        exercise.setAnswers(List.of("want", "'m wanting"));
        exercise.setTip("We use the present simple with stative verbs.");
        exerciseRepository.save(exercise);

        for (Exercise item : exerciseRepository.findAll()) {
            log.info(item.toString());
        }

        LearningSession learningSession = LearningSession.builder().sessionHash("a").exercises(List.of(1l, 2l, 3l, 4l)).build();
        log.info(learningSessionRepository.save(learningSession).toString());
    }
}
