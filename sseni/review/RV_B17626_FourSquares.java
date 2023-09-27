package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
1 = 1
2 = 1 + 1
3 = 1 + 1 + 1
4 = 2^2
5 = 2^2 + 1
6 = 2^2 + 1 + 1
7 = 2^2 + 1 + 1 + 1
8 = 2^2 + 2^2
9 = 3^3
10 = 3^3 + 1
 */
// 두려웠던 것과 다르게 1부터 10까지 규칙을 쓰다 보니까 금방 떠올랐다.
// 왜 저번에 풀었을 땐 이렇게 써보지 않았지 ?
public class RV_B17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = 5;

            for (int j = 1; j <= Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}

