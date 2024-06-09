package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12904_A와B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        while (s.length() < t.length()) {
            t = t.endsWith("A") ?
                    t.substring(0, t.length() - 1) :
                    new StringBuilder(t).reverse().substring(1);
        }

        System.out.println(t.equals(s) ? 1 : 0);
    }
}
