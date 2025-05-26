package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9935_문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();
        int len = target.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            if (sb.length() >= len) {
                if (sb.substring(sb.length() - len).equals(target)) {
                    sb.delete(sb.length() - len, sb.length());
                }
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
