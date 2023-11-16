package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RV_B2225_합분해 {
    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(dp[N][K]);
    }

    static void solution() {
        for (int i = 1; i <= K; i++) dp[0][i] = 1;
        for (int i = 1; i <= N; i++) dp[i][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_000;
            }
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][K + 1];  // n 을 k개로 만드는 경우의 수
    }
}
