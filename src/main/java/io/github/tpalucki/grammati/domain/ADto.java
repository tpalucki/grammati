package io.github.tpalucki.grammati.domain;

import lombok.Builder;

import java.util.List;

@Builder
public class ADto {

    private List<Question> questions;
}
