package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 6, 10, 13, 9, 8, 1
// 6 16 23 28 33 33
public class RV_B2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];
        dp[0] = arr[0];

        if(n > 1) dp[1] = arr[0] + arr[1];
        if (n > 2) dp[2] = Math.max(arr[0] + arr[1], Math.max(arr[0], arr[1]) + arr[2]);

        for (int i = 3; i < n; i++) {
            // 현재 잔 선택 x, 이전 잔 선택 x, 둘다 선택
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i]);
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
