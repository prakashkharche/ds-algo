package com.ds;

/**
 * Created by prakash.vijay on 02/06/17.
 */
public class Arrays {
    public void printZigZag(int[] array) {
        boolean shouldBeGreater = true;
        for (int i=1; i<array.length; i++) {
            if (array[i] < array[i-1] && shouldBeGreater) {
                swap(array, i-1, i);
            } else if (array[i] > array[i-1] && !shouldBeGreater) {
                swap(array, i-1, i);
            }
            shouldBeGreater = !shouldBeGreater;
        }
        System.out.println(java.util.Arrays.toString(array));
    }

    private static void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
}
