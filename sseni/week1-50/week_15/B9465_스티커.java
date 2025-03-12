package com.example.algorithm.study.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// n이 1일 때를 생각 못하고 ArrayIndexOutBounds ~
public class B9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n][2];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    dp[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            if(n == 1){
                sb.append(Math.max(dp[0][0], dp[0][1])).append("\n");
                continue;
            }

            dp[1][0] = dp[0][1] + dp[1][0];
            dp[1][1] = dp[0][0] + dp[1][1];
            for (int i = 2; i < n; i++) {
                dp[i][0] += Math.max(dp[i - 1][1], dp[i - 2][1]);
                dp[i][1] += Math.max(dp[i - 1][0], dp[i - 2][0]);
            }
            sb.append(Math.max(dp[n - 1][0], dp[n - 1][1])).append("\n");
        }

        System.out.println(sb);
    }
}
