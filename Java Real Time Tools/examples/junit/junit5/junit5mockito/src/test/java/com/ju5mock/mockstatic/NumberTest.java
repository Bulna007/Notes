package com.ju5mock.mockstatic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NumberTest {
    Number number;

    @BeforeEach
    void init() {
        number = new Number();
    }

    @Test
    void testBigNumber() {
        int[] inArray = new int[]{10, 1, 2, 3, 8, 5};
        int[] sortedArray = new int[] {1,2,3,5,8,10};

        try(MockedStatic<ArrayHelper> arrayHelperMockedStatic = Mockito.mockStatic(ArrayHelper.class)) {
            arrayHelperMockedStatic.when(()->ArrayHelper.sort(inArray)).thenReturn(sortedArray);
            Assertions.assertEquals(10, number.bigNumber(inArray));
        }
    }
}
