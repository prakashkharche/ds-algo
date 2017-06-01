package com.algo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by prakash.vijay on 01/06/17.
 */
public class StringsTest {

    private Strings strings;
    @Before
    public void setUp() throws Exception {
        strings = new Strings();
    }

    @Test
    public void testPermutations() throws Exception {
        String s = "ABCD";
        strings.permutations("", s);

    }

    @After
    public void tearDown() throws Exception {


    }
}
