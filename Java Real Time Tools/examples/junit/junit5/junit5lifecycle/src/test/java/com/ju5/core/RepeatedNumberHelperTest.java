package com.ju5.core;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RepeatedNumberHelperTest {
    NumberHelper numberHelper;

    @BeforeEach
    void setUp() {
        numberHelper = new NumberHelper();
    }

    @RepeatedTest(5)
    void testIsPrime(RepetitionInfo repetitionInfo) {
        int n = 11;
        System.out.println("repetition: " + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
        Assertions.assertTrue(numberHelper.isPrime(n));
    }

    @RepeatedTest(value=5, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    @DisplayName("verify isPrime(2)")
    void testIsPrimeWithNumberTwo() {
        int n = 2;
        Assertions.assertTrue(numberHelper.isPrime(n));
    }

    @Test
    @Disabled("disabled temporarily, waiting for requirement confirmation")
    void testIsPrimeWithZero() {
        int n = 0;
        Assertions.assertTrue(numberHelper.isPrime(n));
    }

    @AfterEach
    void tearDown() {
        numberHelper = null;
    }
}
