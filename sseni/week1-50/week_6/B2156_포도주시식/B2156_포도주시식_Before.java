package com.example.algorithm.study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 사실 알고리즘 자체는 흐름은 비슷한데..
// 이렇게 풀다가 일차원으로 할 수 있다는 걸 깨달았어야 했다.
public class B2156_Before {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(arr[0]);
            return;
        } else if (n == 2) {
            System.out.println(arr[0] + arr[1]);
            return;
        } else if (n == 3) {
            System.out.println(Math.max(arr[0] + arr[1], Math.max(arr[1] + arr[2], arr[0] + arr[2])));
            return;
        }

        int[][] dp = new int[n][3];
        dp[0][0] = arr[0];
        dp[0][1] = 0;
        dp[0][2] = arr[0];
        dp[1][0] = 0;
        dp[1][1] = arr[1];
        dp[1][2] = arr[0] + arr[1];

        int nonSelect = 2;
        for (int i = 2; i < n; i++) {
            if (nonSelect == 0) {
                dp[i][1] = dp[i - 2][1] + arr[i];
                dp[i][2] = dp[i - 1][2] + arr[i];
            } else if (nonSelect == 1) {
                dp[i][0] = dp[i - 1][0] + arr[i];
                dp[i][2] = dp[i - 2][2] + arr[i];
            } else {
                dp[i][0] = dp[i - 2][0] + arr[i];
                dp[i][1] = dp[i - 1][1] + arr[i];
            }

            dp[i][nonSelect] = dp[i - 1][nonSelect];
            nonSelect--;
            nonSelect = nonSelect < 0 ? 2 : nonSelect;
        }

        System.out.println(Arrays.stream(dp[n - 1]).max().getAsInt());
    }
}
