package io.github.tpalucki.grammati.service;

import io.github.tpalucki.grammati.domain.Question;
import io.github.tpalucki.grammati.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DailyProcessingService {

    private final EmailService emailService;

    /**
     * Load users
     * For each one:
     * pick 5 questions
     * generate id for these questions
     * store id in db
     * send each one email with id
     */
    // TODO send email on startup
//    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        log.info("hello world, I have just started up");

        List<User> user = List.of(new User("tpalucki@gmail.com"));

        user.forEach(u -> {
            var email = u.getEmail();
            List<Question> questions = List.of();

            var quizId = "xyz";
            emailService.sendDailyQuiz(email, quizId);
        });

    }
}
