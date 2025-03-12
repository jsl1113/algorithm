package com.example.algorithm.study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// dp 를 1차원 or 2차원을 고민하고 나서 부터는 금방 풀었던 거 같다.
// 해당 색을 칠한다고 가정, 전꺼에서 해당 색 제외한 색 비용 중 작은 값을 가져온다.
public class B1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] strArray = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(strArray[j]);
            }
        }

        int[][] dp = new int[n][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = arr[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
        }

        System.out.println(Arrays.stream(dp[n-1]).min().getAsInt());
    }
}
