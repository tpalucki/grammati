package io.github.tpalucki.grammati.configuration;

import io.github.tpalucki.grammati.repository.ExerciseRepository;
import io.github.tpalucki.grammati.repository.QuizRepository;
import io.github.tpalucki.grammati.repository.SubscriptionRepository;
import io.github.tpalucki.grammati.repository.example.CarRepository;
import io.github.tpalucki.grammati.repository.example.EngineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialDataConfig {

    @Bean
    public CommandLineRunner initDatabaseRunner(SubscriptionRepository subscriptionRepository,
                                                ExerciseRepository exerciseRepository,
                                                QuizRepository quizRepository,
                                                EngineRepository engineRepository,
                                                CarRepository carRepository) {
        return new InitDatabaseRunner(subscriptionRepository, exerciseRepository, quizRepository, engineRepository, carRepository);
    }
}
