package io.github.tpalucki.grammati.domain;

import lombok.*;

@Data
@ToString
@RequiredArgsConstructor
public class AnswerDto {

    private String quizReference;
    private Long questionReference;
    private String answer;
}
