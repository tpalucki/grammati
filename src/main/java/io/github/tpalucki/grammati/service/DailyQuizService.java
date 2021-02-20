package io.github.tpalucki.grammati.service;

import io.github.tpalucki.grammati.component.ClientPathProvider;
import io.github.tpalucki.grammati.domain.*;
import io.github.tpalucki.grammati.repository.QuestionRepository;
import io.github.tpalucki.grammati.repository.QuizRepository;
import io.github.tpalucki.grammati.repository.QuizToQuestionsRepository;
import io.github.tpalucki.grammati.repository.SubscriptionRepository;
import io.github.tpalucki.grammati.service.generator.ReferenceGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.Math.abs;

@Service
@RequiredArgsConstructor
@Slf4j
public class DailyQuizService {

    private final QuizRepository quizRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final QuizToQuestionsRepository quizToQuestionsRepository;
    private final QuestionRepository questionRepository;
    private final MailService mailService;
    private final ReferenceGenerator referenceGenerator;
    private final ClientPathProvider clientPathProvider;

    @Value("${app.quiz.questions.number}")
    int questionsPerQuiz;

    public void processDailyQuiz() {
        log.info("Processing daily quizzes");

        List<SubscriptionForm> subscriptionsToHandle = subscriptionRepository.findAllByActiveIsTrue();
        log.info("Found {} subscriptions for today.", subscriptionsToHandle.size());

        Level level = Level.A1;
        List<Question> allQuestions = questionRepository.findByLevelEquals(level);
        log.info("Found {} questions on level {}", allQuestions.size(), level);

        for (SubscriptionForm subscription : subscriptionsToHandle) {
            String reference = referenceGenerator.generate();

            Quiz quiz = new Quiz();
            quiz.setSessionId(reference);

            final Quiz savedQuiz = quizRepository.save(quiz);
            final Long savedQuizGeneratedId = savedQuiz.getQuizId();

            chooseQuestionsForQuiz(savedQuizGeneratedId, allQuestions);

            var quizLink = clientPathProvider.provideDailyQuizLink(savedQuiz.getSessionId());
            log.info("Daily quiz link: {}", quizLink);

            String email = subscription.getEmail();
            String name = subscription.getName();
            mailService.sendDailyQuiz(email, name, quizLink);
        }

    }

    private void chooseQuestionsForQuiz(Long savedQuizGeneratedId, List<Question> questions) {
        List<Question> picked = pickRandomQuestions(questions);
        log.info("Picked question quiz {}: {}", savedQuizGeneratedId, questions);
        for (Question question : picked) {
            QuizToQuestions quizToQuestions = new QuizToQuestions();
            quizToQuestions.setQuizId(savedQuizGeneratedId);
            quizToQuestions.setQuestionId(question.getQuestionId());
            quizToQuestionsRepository.save(quizToQuestions);

        }
    }

    private List<Question> pickRandomQuestions(List<Question> questions) {
        Random rand = new Random();
        final int size = questions.size();

        Map<Long, Question> picked = new HashMap<>();
        while (picked.size() < questionsPerQuiz) {
            final Question question = questions.get(abs(rand.nextInt()) % size);
            if (!picked.containsKey(question.getQuestionId())) {
                picked.put(question.getQuestionId(), question);
            }
        }
        return new ArrayList<>(picked.values());
    }

}
