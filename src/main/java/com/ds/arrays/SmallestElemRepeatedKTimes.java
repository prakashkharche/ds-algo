package com.ds.arrays;

/**
 * Created by prakash.vijay on 25/08/17.
 */
public class SmallestElemRepeatedKTimes {
    public static void main(String[] args) {
        int[] a = {2,2,1,3,1};
        System.out.print(smallestElementRepeatedKTimes(a, 2));
    }

    private static int smallestElementRepeatedKTimes(int[] elements, int k) {
        int[] frequencyHash = new int[1000];
        for (int element : elements) {
            ++frequencyHash[element];
        }

        for (int i=0; i<elements.length; i++) {
            if (frequencyHash[i] == k) {
                return i;
            }
        }
        return -1;
    }
}
