package com.example.algorithm.study.week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// dp로 풀고 찾아봤는데, 규칙을 찾아서 1줄이면 끝나는 문제였삼
public class B9657_돌게임3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        System.out.println((n % 7 == 0 || n % 7 == 2) ? "CY" : "SK");

        boolean[] dp = new boolean[1001];
        dp[1] = true;
        dp[3] = true;
        dp[4] = true;

        for (int i = 5; i <= n; i++) {
            if (!dp[i - 4] || !dp[i - 3] || !dp[i - 1]) {
                dp[i] = true;
            }
        }

        System.out.println(dp[n] ? "SK" : "CY");
    }
}
