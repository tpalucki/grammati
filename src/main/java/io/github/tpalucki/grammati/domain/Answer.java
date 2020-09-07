package io.github.tpalucki.grammati.domain;

import lombok.*;

@Data
@ToString
@RequiredArgsConstructor
public class Answer {

    private String quizReference;
    private Long questionReference;
    private String answer;
}
