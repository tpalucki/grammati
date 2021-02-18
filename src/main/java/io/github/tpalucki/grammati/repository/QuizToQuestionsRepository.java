package io.github.tpalucki.grammati.repository;

import io.github.tpalucki.grammati.domain.QuizToQuestions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizToQuestionsRepository extends JpaRepository<QuizToQuestions, Long> {
}
