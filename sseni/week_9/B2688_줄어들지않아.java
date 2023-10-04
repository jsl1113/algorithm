package com.example.algorithm.study.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 어떤 숫자가 줄어들지 않는다 = 그 숫자의 각 자리 수보다 그 왼쪽 자리 수가 작거나 같을 때
// 줄어들지 않는 4자리 수 = 0011, 1111, 1112, 1122, 2223 등 총 715개 (숫자 앞에 0이 있어도 됨)
// n이 주어졌을 때, 줄어들지 않는 n자리 수의 개수를 구하는 프로그램
public class B2688_줄어들지않아 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[65][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(solution(dp, n)).append("\n");
        }

        System.out.println(sb);
    }

    public static long solution(long[][] dp, int n) {
        if (dp[n][0] == 0) { // 이미 이전에 계산된 n 이라면, 다시 계산할 필요가 없음
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j <= 9; j++) {
                    if (j == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        return Arrays.stream(dp[n]).sum();
    }
}
