package com.ju5.core;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class ArrayHelperTest {
    ArrayHelper arrayHelper;

    @BeforeEach
    public void setUp() {
        arrayHelper = new ArrayHelper();
    }

    @Test
    //@DisplayName("test, find bigNumber in the array with multiple numbers in input array")
    @Order(2)
    @Tag("performance")
    void test_BigNumber() {
        int[] inArray = new int[]{10, 20, 34, 2, 4, 7};
        int expectedBigNumber = 34;

        int actualBigNumber = arrayHelper.bigNumber(inArray);
        Assertions.assertEquals(expectedBigNumber, actualBigNumber);
    }

    @Test
    //@DisplayName("test, find bigNumber with same numbers in input array")
    @Order(1)
    void test_BigNumber_With_SameNumbers_In_Array() {
        int[] inArray = new int[]{10, 10, 10, 10, 10};
        int expectedBigNumber = 10;

        int actualBigNumber = arrayHelper.bigNumber(inArray);
        Assertions.assertEquals(expectedBigNumber, actualBigNumber);
    }

    @Test
    //@DisplayName("test, find bigNumber with single number in input array")
    @Order(3)
    void test_BigNumber_With_SingleNumber_Array() {
        int[] inArray = new int[]{10};
        int expectedBigNumber = 10;

        int actualBigNumber = arrayHelper.bigNumber(inArray);
        Assertions.assertEquals(expectedBigNumber, actualBigNumber);
    }

    @AfterEach
    public void tearDown() {
        arrayHelper = null;
    }


}
