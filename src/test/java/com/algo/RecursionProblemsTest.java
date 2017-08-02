package com.algo;


import org.junit.Before;
import org.junit.Test;

/**
 * Created by prakash.vijay on 11/07/17.
 */
public class RecursionProblemsTest {


    RecursionProblems recursionProblems;
    @Before
    public void setUp() throws Exception {
        recursionProblems = new RecursionProblems();
    }

    @Test
    public void name() throws Exception {
        int[] input = {1, 2, 2, 1};
        recursionProblems.printDigitInterpretations(input, 0, "");
    }
}
