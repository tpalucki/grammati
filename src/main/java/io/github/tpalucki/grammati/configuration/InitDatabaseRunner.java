package io.github.tpalucki.grammati.configuration;

import io.github.tpalucki.grammati.domain.Excercise;
import io.github.tpalucki.grammati.repository.ExcerciseRespository;
import io.github.tpalucki.grammati.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class InitDatabaseRunner implements CommandLineRunner {

    private final SubscriptionRepository subscriptionRepository;
    private final ExcerciseRespository excerciseRespository;


    @Override
    public void run(String... args) throws Exception {
        Excercise excercise = new Excercise();
        excercise.setQuestion("She goes/is going to the gym twice a week.");
        excercise.setAnswers(List.of("goes", "is going"));
        excercise.setTip("We use the present simple for things that we do regularly.");
        excerciseRespository.save(excercise);

        excercise = new Excercise();
        excercise.setQuestion("Water boils/is boiling at 100o C.");
        excercise.setAnswers(List.of("boils", "is boiling"));
        excercise.setTip("We use the present simple for things that are true in general.");
        excerciseRespository.save(excercise);

        excercise = new Excercise();
        excercise.setQuestion("He works/is working in a bank.");
        excercise.setAnswers(List.of("works", "is working"));
        excercise.setTip("We use the present simple for situations which are permanent.");
        excerciseRespository.save(excercise);

        excercise = new Excercise();
        excercise.setQuestion("I want/’m wanting to go home.");
        excercise.setAnswers(List.of("want", "'m wanting"));
        excercise.setTip("We use the present simple with stative verbs.");
        excerciseRespository.save(excercise);

        for (Excercise item : excerciseRespository.findAll()) {
            log.info(item.toString());
        }
    }
}
