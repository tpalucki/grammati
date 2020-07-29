package io.github.tpalucki.grammati.configuration;

import io.github.tpalucki.grammati.repository.ExerciseRepository;
import io.github.tpalucki.grammati.repository.LearningSessionRepository;
import io.github.tpalucki.grammati.repository.SubscriptionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialDataConfig {

    @Bean
    public CommandLineRunner initDatabaseRunner(SubscriptionRepository subscriptionRepository,
                                                ExerciseRepository exerciseRepository,
                                                LearningSessionRepository learningSessionRepository) {
        return new InitDatabaseRunner(subscriptionRepository, exerciseRepository, learningSessionRepository);
    }
}
