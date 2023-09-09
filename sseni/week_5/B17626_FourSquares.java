package com.example.algorithm.study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[1] = 1;
        for(int i=2; i<=n; i++) dp[i] = 5;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= (int) Math.sqrt(i); j++) {
                // 이 점화식도 역시 앞의 나의 코드에서,
                // 만약, n-m 이 list2에 있다면? n-m 과 m 으로 만들 수 있음
                // 이 풀이와 동일한 알고리즘이다.
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
