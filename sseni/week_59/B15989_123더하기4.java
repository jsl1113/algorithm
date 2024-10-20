package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 순서에 상관없이
public class B15989_123더하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] tc = new int[T];
        int max = 0;

        for (int i = 0; i < T; i++) {
            tc[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, tc[i]);
        }

        int[][] dp = new int[max + 1][4];
        for (int i = 1; i <= 3; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= 3; j++) {
                dp[i][j] = dp[i][j - 1];
                if(i-j >=0) dp[i][j] += dp[i - j][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dp[tc[i]][3]).append("\n");
        }

        System.out.print(sb);
    }
}
