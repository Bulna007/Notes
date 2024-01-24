package com.ju5mock.core;

import com.ju5mock.exception.EmptyArrayException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArraySorterTest {
    ArraySorter arraySorter;

    @BeforeEach
    void init() {
        arraySorter = new ArraySorter();
    }

    @ParameterizedTest
    @MethodSource("arraySource")
    void testSort(int[] inArray, int[] expectedSortedArray) throws EmptyArrayException {
        int[] actualSortedArray = arraySorter.sort(inArray);
        Assertions.assertArrayEquals(expectedSortedArray, actualSortedArray);
    }

    static Stream<Arguments> arraySource() {
        return Stream.of(
                Arguments.of(new int[]{10, 1, 2, 34, 52, 21}, new int[]{1, 2, 10, 21, 34, 52}),
                Arguments.of(new int[]{10, 10, 2, 2, 52, 52}, new int[]{2, 2, 10, 10, 52, 52}),
                Arguments.of(new int[]{10, 10, 10, 10, 10}, new int[]{10, 10, 10, 10, 10}),
                Arguments.of(new int[]{10}, new int[]{10}),
                Arguments.of(new int[]{10, -1, 2, -34, 52, 21}, new int[]{-34, -1, 2, 10, 21, 52})
        );
    }

    @AfterEach
    void cleanup() {
        arraySorter = null;
    }
}
