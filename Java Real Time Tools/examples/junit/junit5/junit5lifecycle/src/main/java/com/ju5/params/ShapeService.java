package com.ju5.params;

import com.ju5.bean.Rectangle;

public class ShapeService {
    public int area(Rectangle rectangle) {
        return rectangle.getLength() * rectangle.getBreadth();
    }
}
