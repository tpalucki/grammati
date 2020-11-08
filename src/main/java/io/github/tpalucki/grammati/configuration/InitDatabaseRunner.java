package io.github.tpalucki.grammati.configuration;

import io.github.tpalucki.grammati.domain.Question;
import io.github.tpalucki.grammati.domain.Answer;
import io.github.tpalucki.grammati.domain.Quiz;
import io.github.tpalucki.grammati.repository.AnswerRepository;
import io.github.tpalucki.grammati.repository.ExerciseRepository;
import io.github.tpalucki.grammati.repository.QuizRepository;
import io.github.tpalucki.grammati.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Slf4j
@RequiredArgsConstructor
public class InitDatabaseRunner implements CommandLineRunner {

  private final SubscriptionRepository subscriptionRepository;
  private final ExerciseRepository exerciseRepository;
  private final QuizRepository quizRepository;
  private final AnswerRepository answerRepository;

  @Override
  public void run(String... args) {
    initQuestionsDb();
  }

  @Transactional
  public void initQuestionsDb() {
    // question 1
    var question = new Question();
    question.setQuestion("She goes/is going to the gym twice a week.");
    question.setTip("We use the present simple for things that we do regularly.");
    exerciseRepository.save(question);

    Answer qa1 = new Answer();
    qa1.setAnswerText("goes");
    qa1.setCorrect(true);
//    qa1.setQuestion(question);
    answerRepository.save(qa1);

    Answer qa2 = new Answer();
    qa2.setAnswerText("is going");
    qa2.setCorrect(false);
//    qa2.setQuestion(question);
    answerRepository.save(qa2);

    question.setAnswers(Set.of(qa1, qa2));
    exerciseRepository.save(question);

    // question 2
    var question2 = new Question();
    question2.setQuestion("Water boils/is boiling at 100o C.");
    question2.setTip("We use the present simple for things that are true in general.");
    exerciseRepository.save(question2);

    Answer qa3 = new Answer();
    qa3.setAnswerText("boils");
    qa3.setCorrect(true);
//    qa3.setQuestion(question2);
    answerRepository.save(qa3);

    Answer qa4 = new Answer();
    qa4.setAnswerText("is boiling");
    qa4.setCorrect(false);
//    qa4.setQuestion(question2);
    answerRepository.save(qa4);

    question2.setAnswers(Set.of(qa3, qa4));
    exerciseRepository.save(question2);

    // question 3
    var question3 = new Question();
    question3.setQuestion("He works/is working in a bank.");
    question3.setTip("We use the present simple for situations which are permanent.");
    exerciseRepository.save(question3);

    Answer qa5 = new Answer();
    qa5.setAnswerText("works");
    qa5.setCorrect(true);
//    qa5.setQuestion(question3);
    answerRepository.save(qa5);

    var qa6 = new Answer();
    qa6.setAnswerText("is working");
    qa6.setCorrect(false);
//    qa6.setQuestion(question3);
    answerRepository.save(qa6);

    question3.setAnswers(Set.of(qa5, qa6));
    exerciseRepository.save(question3);

    // question 4
    var question4 = new Question();
    question4.setQuestion("I want/’m wanting to go home.");
    question4.setTip("We use the present simple with stative verbs.");
    exerciseRepository.save(question4);

    Answer qa7 = new Answer();
    qa7.setAnswerText("want");
    qa7.setCorrect(true);
//    qa7.setQuestion(question4);
    answerRepository.save(qa7);

    Answer qa8 = new Answer();
    qa8.setAnswerText("'m wanting");
    qa8.setCorrect(false);
//    qa8.setQuestion(question4);
    answerRepository.save(qa8);

    question4.setAnswers(Set.of(qa7, qa8));
    exerciseRepository.save(question4);

    Quiz quiz =
        Quiz.builder()
            .sessionId("a")
            .questions(Set.of(question, question2, question3, question4))
            .build();
    log.info(quizRepository.save(quiz).toString());
  }
}
