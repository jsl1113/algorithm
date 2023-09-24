package com.example.algorithm.study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RV_B1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String[] strArray = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(strArray[j - 1]);
            }
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(Arrays.stream(dp[i]).max().getAsInt(), answer);
        }

        System.out.println(answer * answer);
    }
}
