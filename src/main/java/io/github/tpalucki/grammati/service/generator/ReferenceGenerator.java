package io.github.tpalucki.grammati.service.generator;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

@RequiredArgsConstructor
public class ReferenceGenerator {

    private final int length;
    private final boolean useLetters;
    private final boolean useNumbers;

    public String generate() {
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
}
