package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// MAX 를 더해버려서 음수 0 이상의 수로 처리
public class B1788_피보나치수의확장 {
    static int MAX = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) + MAX;

        long[] dp = new long[2_000_001];
        dp[MAX] = 0;
        dp[MAX + 1] = 1;

        if (n < MAX) {
            for (int i = 999_999; i >= n; i--) {
                dp[i] = (dp[i + 2] - dp[i + 1]) % 1_000_000_000;
            }
        } else {
            for (int i = 1_000_002; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_000;
            }
        }

        if (dp[n] > 0) System.out.println(1);
        else if (dp[n] == 0) System.out.println(0);
        else System.out.println(-1);

        System.out.println(Math.abs(dp[n]));
    }
}
