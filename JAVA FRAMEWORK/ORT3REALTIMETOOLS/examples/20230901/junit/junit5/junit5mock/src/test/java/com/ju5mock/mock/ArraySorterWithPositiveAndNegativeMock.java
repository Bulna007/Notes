package com.ju5mock.mock;

import com.ju5mock.core.ArraySorter;

public class ArraySorterWithPositiveAndNegativeMock extends ArraySorter {
    @Override
    public int[] sort(int[] inArray) {
        return new int[] {-54, -2, 1, 5, 10, 21};
    }
}
