package com.ju5.core;

import com.ju5.bean.Square;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SquareTest {
    Square square;

    @BeforeEach
    void init() {
        square = new Square();
    }

    @AfterEach
    void cleanup() {
        square = null;
    }

    @Test
    void testArea() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            square.area(-10);
        });
    }

}
