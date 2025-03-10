package com.example.algorithm.study.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17404_RGB거리2 {
    static int n;
    static int[][] arr, dp;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void solution() {
        answer = new int[3];
        for (int i = 0; i < 3; i++) {  // 1번 집 색을 고정해서 각각 계산
            for (int j = 0; j < 3; j++) {
                if (i == j) dp[0][j] = arr[0][j];
                else dp[0][j] = 1001;
            }

            for (int j = 1; j < n; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];
            }

            if (i == 0) answer[0] = Math.min(dp[n - 1][1], dp[n - 1][2]);
            if (i == 1) answer[1] = Math.min(dp[n - 1][0], dp[n - 1][2]);
            if (i == 2) answer[2] = Math.min(dp[n - 1][0], dp[n - 1][1]);
        }
        System.out.println(Arrays.stream(answer).min().getAsInt());
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 빨
            arr[i][1] = Integer.parseInt(st.nextToken()); // 초
            arr[i][2] = Integer.parseInt(st.nextToken()); // 파
        }
        dp = new int[n][3];
    }
}
