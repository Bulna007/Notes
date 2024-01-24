package com.ju5.params;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {
    Number number;

    @BeforeEach
    void init() {
        number = new Number();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 7, 11, 17, 19})
    void testForAllPrimeNumbers(int n) {
        Assertions.assertTrue(number.isPrimeNumber(n));
    }

    @ParameterizedTest
    @CsvSource({"10,20,10", "-10,20,30", "0,0,0", "-1,-1,0"})
    void testSubstract(int a, int b, int expectedSub) {
        Assertions.assertEquals(expectedSub, number.substract(a, b));
    }

    @AfterEach
    void cleanup() {
        number = null;
    }
}
