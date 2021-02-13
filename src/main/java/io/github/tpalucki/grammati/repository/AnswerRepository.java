package io.github.tpalucki.grammati.repository;

import io.github.tpalucki.grammati.domain.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<UserAnswer, Long> {

}
