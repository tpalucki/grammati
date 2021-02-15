package io.github.tpalucki.grammati.service.generator;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ReferenceGeneratorTest {

    @Test
    void givenUsingApache_whenGeneratingRandomStringBounded_thenCorrect() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        System.out.println(generatedString);
    }

    @Test
    void shouldGenerateRandom() {
        ReferenceGenerator generator = new ReferenceGenerator(24, true, true);

        String generated = generator.generate();

        assertThat(generated).hasSize(24).isNotBlank();
        System.out.println("generated = " + generated);
    }
}