package com.example.algorithm.study.week24;

import java.util.Arrays;

public class P12913_땅따먹기 {

    static int solution(int[][] land) {
        int N = land.length;

        int[][] dp = new int[N][4];
        System.arraycopy(land[0], 0, dp[0], 0, 4);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + land[i][j]);
                }
            }
        }

        return Arrays.stream(dp[N - 1]).max().getAsInt();
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
    }
}
