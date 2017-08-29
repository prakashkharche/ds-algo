package com.ds.arrays;

/**
 * Created by prakash.vijay on 28/08/17.
 */
public class RearrangePosAndNegNumbers {
    public static void main(String[] args) {
        int a[] = {-1, 2, -3, 4, 5, 6, 7, 8, 9};
        rearrangeAlternate(a);
        for (int element : a) {
            System.out.print(element+" ");
        }
    }

    private static void rearrangeAlternate(int[] elements) {
        int pIndex = 0;
        int nIndex = 0;
        for (int index = 0; index < elements.length; index += 2) {
            if (elements[index] < 0) {
                pIndex = index;
                break;
            }
        }

        for (int index = 1; index < elements.length; index += 2) {
            if (elements[index] > 0) {
                nIndex = index;
                break;
            }
        }

        int selectorIndex = elements.length-1;
        while (pIndex <= selectorIndex && nIndex <= selectorIndex) {
            if (elements[selectorIndex] > 0) {
                swap(elements, pIndex, selectorIndex);
                boolean pIndexFound = false;
                while (!pIndexFound && pIndex <= selectorIndex) {
                    if (elements[pIndex] > 0) {
                        pIndex += 2;
                    } else {
                        pIndexFound = true;
                    }
                }
                continue;
            }
            if (elements[selectorIndex] < 0) {
                swap(elements, nIndex, selectorIndex);
                boolean nIndexFound = false;
                while (!nIndexFound && nIndex <= selectorIndex) {
                    if (elements[nIndex] < 0) {
                        nIndex += 2;
                    } else {
                        nIndexFound = true;
                    }
                }
            }

        }
        if (pIndex < selectorIndex) {
             swap(elements, pIndex, selectorIndex);
        }
        if (nIndex < selectorIndex) {
            swap(elements, nIndex, selectorIndex);
        }
    }

    private static void swap(int[] elements, int i1, int i2) {
        int temp = elements[i1];
        elements[i1] = elements[i2];
        elements[i2] = temp;
    }
}
