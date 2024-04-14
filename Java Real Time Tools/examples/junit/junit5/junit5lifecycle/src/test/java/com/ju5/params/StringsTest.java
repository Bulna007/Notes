package com.ju5.params;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringsTest {
    Strings strings;

    @BeforeEach
    void init() {
        strings = new Strings();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testCountVowels(String in) {
        Assertions.assertEquals(0, strings.countVowels(in));
    }

    @AfterEach
    void cleanup() {
        strings = null;
    }
}
