package io.github.tpalucki.grammati.service.generator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Slf4j
class ReferenceGeneratorTest {

    @Test
    void shouldGenerateRandom() {
        ReferenceGenerator generator = new ReferenceGenerator(24, true, true);

        String generated = generator.generate();

        assertThat(generated).hasSize(24).isNotBlank();
        log.info("generated: {}", generated);
    }
}