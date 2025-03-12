package com.example.algorithm.study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 최대 수익을 구하는 프로그램이고 문제 흐름 상 dp 문제 같았다.
// 해당 일정마다 순회하면서, (해당 일자 + 걸리는 기간) dp 를 갱신하는 방식
public class B14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 10];
        int[] p = new int[n + 10];
        int[] dp = new int[n + 10];

        for (int i = 1; i <= n; i++) {
            String[] strArray = br.readLine().split(" ");
            t[i] = Integer.parseInt(strArray[0]);
            p[i] = Integer.parseInt(strArray[1]);
        }

        for (int i = 1; i <= n + 1; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            dp[t[i] + i] = Math.max(dp[t[i] + i], dp[i] + p[i]);
            System.out.println(i + " " + Arrays.toString(dp));
        }

        System.out.println(dp[n + 1]);
    }
}
