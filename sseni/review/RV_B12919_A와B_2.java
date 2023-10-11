package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RV_B12919_A와B_2 {
    static String S, T;
    static boolean result = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        dfs(T);
        System.out.println(result ? 1 : 0);
    }

    public static void dfs(String str) {
        if (str.length() == S.length()) {
            if (str.equals(S)) result = true;
            return;
        }

        // T 의 맨 앞이 B 면, 제거하고 뒤집기해서 재귀 호출
        if (str.charAt(0) == 'B')
            dfs(new StringBuilder(str.substring(1)).reverse().toString());

        // T의 맨 앞이 A 면, 제거하고 재귀 호출
        if (str.charAt(str.length() - 1) == 'A')
            dfs(str.substring(0, str.length() - 1));

    }
}
