package io.github.tpalucki.grammati.service;

import io.github.tpalucki.grammati.config.AppConfig;
import io.github.tpalucki.grammati.domain.Quiz;
import io.github.tpalucki.grammati.domain.QuizToQuestions;
import io.github.tpalucki.grammati.domain.SubscriptionForm;
import io.github.tpalucki.grammati.repository.QuizRepository;
import io.github.tpalucki.grammati.repository.QuizToQuestionsRepository;
import io.github.tpalucki.grammati.repository.SubscriptionRepository;
import io.github.tpalucki.grammati.service.generator.ReferenceGenerator;
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
    private final QuizToQuestionsRepository quizToQuestionsRepository;
    private final MailService mailService;
    private final ReferenceGenerator referenceGenerator;
    private final AppConfig appConfig;

    public void processDailyQuiz() {
        log.info("Processing daily quizzes");

        List<SubscriptionForm> subscriptionsToHandle = subscriptionRepository.findAllByActiveIsTrue();
        log.info("Found {} subscriptions for today.", subscriptionsToHandle.size());

        for (SubscriptionForm subscription : subscriptionsToHandle) {


            String reference = referenceGenerator.generate();

            Quiz quiz = new Quiz();
            quiz.setSessionId(reference);

            final Quiz savedQuiz = quizRepository.save(quiz);
            final Long savedQuizGeneratedId = savedQuiz.getQuizId();

            // TOOD quiz generation strategy
            QuizToQuestions quizToQuestions = new QuizToQuestions();
            quizToQuestions.setQuizId(savedQuizGeneratedId);
            quizToQuestions.setQuestionId(4L);
            quizToQuestionsRepository.save(quizToQuestions);


            var quizLink = appConfig.getClientUrl() + appConfig.getDailyQuizPath() + "/" + savedQuiz.getSessionId();//TODO export, TODO reference instead of sessionID
            log.info("Daily quiz link: {}", quizLink);

            String email = subscription.getEmail();
            String name = subscription.getName();
            mailService.sendDailyQuiz(email, name, quizLink);
        }

    }

}
