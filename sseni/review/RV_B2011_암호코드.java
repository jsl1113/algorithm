package com.example.algorithm.study.review.week16_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RV_B2011_암호코드 {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        dp = new long[s.length() + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            int a = s.charAt(i - 1) - '0';
            int b = s.charAt(i - 2) - '0';

            if(a != 0) dp[i] += dp[i - 1];
            if(b == 1 || (b == 2 && a <= 6)) dp[i] += dp[i - 2];
            dp[i] %= 1_000_000;
        }

        System.out.println(dp[s.length()]);
    }
}
