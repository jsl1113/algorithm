package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
자릿수에 따라,
1자리 - 1 1 1 1 1 1 1 1 1 1 = 10
2자리 - 10 9 8 7 6 5 4 3 2 1 = 55
3자리 - 55 45 36 28 21 15 10 6 3 1 = 220
dp[3][1] = dp[3][0] - dp[2][0]
dp[3][2] = dp[3][1] - dp[2][1]
*/
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
            long sum = dp[i - 1][0];
            for (int j = 1; j < 10; j++) {
                sum += dp[i - 1][j] % MOD;
            }
            arr[i - 1] = sum % MOD;

            dp[i][9] = 1;
            for (int j = 8; j >= 0; j--) {
                dp[i][j] = dp[i][j+1] % MOD + dp[i-1][j] % MOD;
                dp[i][j] %= MOD;
            }
        }

        long sum = dp[n][0];
        for (int j = 1; j < 10; j++) {
            sum += dp[n][j] % MOD;
        }
        arr[n] = sum % MOD;


        System.out.println(arr[n]);
    }
}
