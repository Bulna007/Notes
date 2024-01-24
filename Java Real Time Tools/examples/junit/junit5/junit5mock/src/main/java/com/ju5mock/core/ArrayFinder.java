package com.ju5mock.core;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class ArrayFinder {
    private ArraySorter arraySorter;

    public boolean findElement(int[] inArray, int elem) {
        int[] sortedArray = null;
        int min = 0;
        int max = 0;
        int median = 0;
        boolean found = false;

        sortedArray = arraySorter.sort(inArray);
        //Arrays.stream(sortedArray).forEach(System.out::println);
        min = 0;
        max = sortedArray.length;


        while (min <= max && found == false) {
            //printArray(sortedArray, min, max);
            median = (min + max) / 2;
            //System.out.println("median : " + median + " min : " + min + " max: " + max);
            if (sortedArray[median] == elem) {
                found = true;
            } else if (sortedArray[median] < elem) {
                min = median + 1;
            } else if (sortedArray[median] > elem) {
                max = median - 1;
            }
        }
        return found;
    }

    private void printArray(int[] in, int min, int max) {
        for(int i = min;i<max;i++) {
            System.out.print(in[i] + " ");
        }
    }

}
