package io.github.tpalucki.grammati.domain.dto;

import lombok.*;

@Data
@ToString
@RequiredArgsConstructor
public class AnswerDto {

  private String quizReference;
  private Long questionReference;
  private Long answerId;
  private String answer;
}
