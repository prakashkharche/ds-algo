package com.algo;

/**
 * Created by prakash.vijay on 11/07/17.
 */
public class RecursionProblems {

    public static void main(String[] args) {
        String s = "";
        s = s + (char) 97;
        s = s + (char) 98;
        System.out.println(s);
    }

    public void printDigitInterpretations(int[] input, int index, String output) {
        if (input.length == index) {
            System.out.println(output);
            return;
        }

        printDigitInterpretations(input, index+1, output+ String.valueOf(Character.toChars(input[index]+96)));
        if (index < input.length-1) {
            int charBase = 10 * input[index] + input[index + 1];
            if (charBase > 26) {
                return;
            }
            printDigitInterpretations(input, index+2, output + String.valueOf(Character.toChars(charBase + 96)));
        }
    }
}
