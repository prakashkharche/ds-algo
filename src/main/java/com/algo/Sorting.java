package com.algo;

/**
 * Created by prakash.vijay on 23/08/17.
 */
public class Sorting {
    public static void quickSort(int[] array) {
        quickSortRec(array, 0, array.length-1);
    }

    private static void quickSortRec(int[] array, int start, int end) {
        if (start < end) {
            int pIndex = partition(array, start, end);
            quickSortRec(array, start, pIndex-1);
            quickSortRec(array, pIndex+1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pIndex = start;
        int pivot = array[end];
        for (int i=start; i<end; i++) {
            if (array[i] < pivot) {
                swap(array, i, pIndex);
                pIndex++;
            }
        }
        swap(array, pIndex, end);
        return pIndex;
    }

    private static void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
}
