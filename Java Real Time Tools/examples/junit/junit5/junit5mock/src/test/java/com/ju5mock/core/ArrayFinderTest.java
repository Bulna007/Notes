package com.ju5mock.core;

import com.ju5mock.mock.ArraySorterMock;
import com.ju5mock.mock.ArraySorterWithPositiveAndNegativeMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayFinderTest {
    ArrayFinder arrayFinder;
    ArraySorter arraySorter;



    @Test
    void testFindElement() {
        int[] inArray = new int[] {10, 54, 2, 1, 34, 21, 5};
        int elem = 5;

        arraySorter = new ArraySorterMock();
        arrayFinder = new ArrayFinder(arraySorter);
        boolean actualFound = arrayFinder.findElement(inArray, elem);
        Assertions.assertTrue(actualFound);
    }

    @Test
    void testFindElementWithPositiveAndNegativeNumbersInArray() {
        int[] inArray = new int[] {10, -54, -2, 1, 34, 21, 5};
        int elem = 10;
        arraySorter = new ArraySorterWithPositiveAndNegativeMock();
        arrayFinder = new ArrayFinder(arraySorter);

        boolean actualFound = arrayFinder.findElement(inArray, elem);
        Assertions.assertTrue(actualFound);
    }

    @AfterEach
    void cleanup() {
        arrayFinder = null;
        arraySorter = null;
    }
}
