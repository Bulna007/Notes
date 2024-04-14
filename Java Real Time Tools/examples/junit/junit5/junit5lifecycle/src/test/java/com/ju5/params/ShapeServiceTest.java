package com.ju5.params;

import com.ju5.bean.Rectangle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ShapeServiceTest {
    ShapeService shapeService;

    @BeforeEach
    void init() {
        shapeService = new ShapeService();
    }

    @ParameterizedTest
    @MethodSource("rectangleSource")
    void testArea(Rectangle rectangle, int expectedArea) {
        Assertions.assertEquals(expectedArea, shapeService.area(rectangle));
    }

    @AfterEach
    void cleanUp() {
        shapeService = null;
    }


    static Stream<Arguments> rectangleSource() {
        return Stream.of(
                Arguments.of(new Rectangle(10, 20), 200),
                Arguments.of(new Rectangle(10, 0), 0),
                Arguments.of(new Rectangle(0, 0), 0)
        );
    }
}
