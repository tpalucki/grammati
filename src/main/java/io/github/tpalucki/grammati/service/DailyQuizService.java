package io.github.tpalucki.grammati.service;

import io.github.tpalucki.grammati.domain.SubscriptionForm;
import io.github.tpalucki.grammati.repository.QuizRepository;
import io.github.tpalucki.grammati.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DailyQuizService {

    private final QuizRepository quizRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final MailService mailService;

    public void processDailyQuiz() {
        log.info("Processing daily quizzes");

        List<SubscriptionForm> subscriptionsToHandle = subscriptionRepository.findAllByActiveIsTrue();
        log.info("Found {} subscriptions for today.", subscriptionsToHandle.size());

        // TODO process with daily quiz
    }

}
