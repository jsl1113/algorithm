package com.example.algorithm.study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 집념의 문제. n = 3 일 때를 다 써보고도 규칙을 잘못 세웠었다.
// (처음엔 시작하는 수대로 썼다가 헤맸다)
// 키 포인트는 이전 n의 끝 자리 수에 따라 개수는 일정하다는 것
// 끝 자리가 0일 땐 다음 수로 1 만 올 수 있고, 마찬가지로 9일 땐 8 만 올 수 있다.
// 2 일 땐 1, 3 이 올 수 있고, 2~8 은 동일하다.
public class B10844 {
    final static long mod = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];

        for (int i = 1; i < 10; i++) dp[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][j + 1] % mod;
                else if (j == 9) dp[i][j] = dp[i - 1][j - 1] % mod;
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
            }
        }

        System.out.println(Arrays.stream(dp[n]).sum() % mod);
    }
}
