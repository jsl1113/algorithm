package com.example.algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2661_좋은수열 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dfs("");
    }

    static boolean dfs(String s) {
        if (s.length() == n) {
            System.out.println(s);
            return true;
        }

        for (int i = 1; i <= 3; i++) {
            String str = s + i;

            if (isGood(str)) {
                if (dfs(str)) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean isGood(String s) {
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            if (s.substring(len - 2 * i, len - i).equals(s.substring(len - i))) {
                return false;
            }
        }
        return true;
    }
}
