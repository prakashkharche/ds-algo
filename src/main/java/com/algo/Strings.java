package com.algo;

/**
 * Created by prakash.vijay on 01/06/17.
 */
public class Strings {
    public void permutations(String prefix, String str) {
        if (str.isEmpty()) {
            System.out.println(prefix);
        }

        for (int i=0 ; i<str.length(); i++) {
            permutations(prefix + str.charAt(i), str.substring(0 , i) + str.substring(i+1, str.length()));
        }
    }
}
