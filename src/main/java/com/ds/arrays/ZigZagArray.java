package com.ds.arrays;

import java.util.Arrays;

/**
 * Created by prakash.vijay on 26/08/17.
 */
public class ZigZagArray {

    public static void main(String[] args) {
        int[] a = {4, 3 ,7, 8, 6, 2, 1};
        zigZag(a);
        System.out.print(Arrays.toString(a));
    }

    private static void zigZag(int[] elements) {
        boolean sToG = true;
        for (int i=0; i<elements.length-1; i++) {
            if (sToG) {
                if (elements[i] > elements[i + 1]) {
                    swap(elements, i, i + 1);
                }
            } else {
                if (elements[i] < elements[i+1]) {
                    swap(elements, i, i+1);
                }
            }
            sToG = !sToG;
        }
    }

    private static void swap(int[] elements, int i1, int i2) {
        int temp = elements[i1];
        elements[i1] = elements[i2];
        elements[i2] = temp;
    }
}
