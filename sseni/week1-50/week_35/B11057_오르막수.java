package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11057_오르막수 {
    static long MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        long[] arr = new long[n + 1];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][9] = 1;

            for (int j = 8; j >= 0; j--) {
                dp[i][j] = (dp[i][j+1] + dp[i-1][j]) % MOD;
            }
        }

        System.out.println(Arrays.stream(dp[n]).sum() % MOD);
    }
}
