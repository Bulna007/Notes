package com.ju5mock.mock;

import com.ju5mock.core.ArraySorter;

public class ArraySorterMock extends ArraySorter {
    @Override
    public int[] sort(int[] inArray) {
        return new int[]{1, 2, 5, 10, 21, 34, 54};
    }
}
