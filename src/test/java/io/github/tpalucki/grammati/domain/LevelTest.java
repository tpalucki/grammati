package io.github.tpalucki.grammati.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LevelTest {

    private static Stream<Arguments> provideIput() {
        return Stream.of(
                Arguments.of(Level.A1, "A1"),
                Arguments.of(Level.A2, "A2"),
                Arguments.of(Level.B1, "B1"),
                Arguments.of(Level.B2, "B2"),
                Arguments.of(Level.C1, "C1"),
                Arguments.of(Level.C2, "C2")
        );
    }

    @ParameterizedTest
    @MethodSource("provideIput")
    void toStringShouldEqualsName(Level level, String expected) {
        assertEquals(expected, level.toString());
    }


}