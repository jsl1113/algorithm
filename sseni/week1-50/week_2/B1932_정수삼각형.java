package com.example.algorithm.study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
//            String[] split = br.readLine().split(" ");
//            for (int j = 0; j < split.length; j++) {
//                dp[i][j] = Integer.parseInt(split[j]);
//            }
            dp[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] += dp[i - 1][0];
            dp[i][i] += dp[i - 1][i - 1];
            for (int j = 1; j < i; j++) {
                dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }

//        int answer = dp[n-1][0];
//        for (int i = 1; i < n; i++) {
//            answer = Math.max(answer, dp[n - 1][i]);
//        }
        System.out.println(Arrays.stream(dp[n-1]).max().getAsInt());
    }
}
