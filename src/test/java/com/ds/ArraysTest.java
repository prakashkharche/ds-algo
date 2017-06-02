package com.ds;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by prakash.vijay on 02/06/17.
 */
public class ArraysTest {
    Arrays arrays;
    @Before
    public void setUp() throws Exception {
        arrays = new Arrays();
    }

    @Test
    public void testZigZag() throws Exception {
        int[] input = {3, 7, 4, 8, 2, 6, 1};
        arrays.printZigZag(input);
    }

    @After
    public void tearDown() throws Exception {


    }
}
