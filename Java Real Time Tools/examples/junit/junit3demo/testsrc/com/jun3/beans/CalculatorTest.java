package com.jun3.beans;

import com.jun3.beans.Calculator;

import junit.framework.*;

public class CalculatorTest extends TestCase {
    Calculator calculator;
    int a;
    int b;
    int na;
    int nb;
    int expectedSum;
    int nexpectedSum;

    public void setUp() {
        calculator = new Calculator();
        a = 10;
        b = 20;
        na = -10;
        nb = -20;

        expectedSum = 30;
        nexpectedSum = -30;
    }

    public void testAddWithPositiveNumbers() {
        int actualSum = calculator.add(a, b);
        assertEquals(expectedSum, actualSum);
    }

    public void testAddWithNegativeNumbers() {
        int actualSum = calculator.add(na, nb);
        assertEquals(nexpectedSum, actualSum);
    }

    public void tearDown() {
        calculator = null;
        a = 0;
        b = 0;
        expectedSum = 0;
    }
}
