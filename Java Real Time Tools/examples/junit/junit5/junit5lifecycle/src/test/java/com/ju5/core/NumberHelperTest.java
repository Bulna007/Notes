package com.ju5.core;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NumberHelperTest {
    NumberHelper numberHelper;

    @BeforeAll
    public void init() {
        System.out.println("one-time initialization running...");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("setUp()");
        numberHelper = new NumberHelper();
    }

    @Test
    void verifyAddNOddNumbers() {
        int n = 5;
        long expectedSum = 4;

        System.out.println("hashcode:" + this.hashCode());
        long actualSum = numberHelper.addNOddNumbers(n);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void verifyAddOddNumbersWithNAsZero() {
        int n = 0;
        long expectedSum = 0;

        System.out.println("hashcode:" + this.hashCode());
        long actualSum = numberHelper.addNOddNumbers(n);
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void testFactorial() {
        int n = 3;
        int expectedFactorial = 6;
        assertEquals(expectedFactorial, numberHelper.factorial(n));
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.MILLISECONDS)
    void testFactorialForBigNumber() {
        int n = 3000000;
        long expectedFactorial = 24242425;
        assertEquals(expectedFactorial, numberHelper.factorial(n));
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tearDown()");
        numberHelper = null;
    }

    @AfterAll
    public void shutdown() {
        System.out.println("performing one-time destruction logic...");
    }
}
