package com.ju5mock.core;

import static org.junit.jupiter.api.Assertions.*;

import com.ju5mock.exception.EmptyArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

//@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
public class ArrayFinderTest {
    @Mock
    ArraySorter arraySorter;
    @InjectMocks
    ArrayFinder arrayFinder;

    @BeforeEach
    void init() throws EmptyArrayException {
        //lenient().when(arraySorter.sort(new int[]{10, 1, 7})).thenReturn(new int[]{1, 7, 10});
    }

    @Test
    void testFindElement() throws EmptyArrayException {
        int[] inArray = new int[]{10, 1, 2, 21, 53, 34};
        int elem = 2;
        when(arraySorter.sort(new int[]{10, 1, 2, 21, 53, 34})).thenReturn(new int[]{1, 2, 10, 21, 34, 53});
        assertTrue(arrayFinder.findElement(inArray, elem));
        verify(arraySorter, atMostOnce()).sort(new int[]{10, 1, 2, 21, 53, 34});
       // atLeastOnce(arraySorter.sort(new int[]{10, 1, 2, 21, 53, 34})).verify();
    }

    @Test
    void testFindElementWithEmptyArray() throws EmptyArrayException {
        when(arraySorter.sort(null)).thenThrow(EmptyArrayException.class);
        assertThrows(EmptyArrayException.class, () -> {
            arrayFinder.findElement(null, 2);
        });
    }
}
