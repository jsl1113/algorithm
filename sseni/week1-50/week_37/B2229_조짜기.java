package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2,5 만 있을 때 -> (2, 5)
// 2,5,7 만 있을 때 -> (2, 5, 7)
// 2,5,7,1 만 있을 때 -> (2, 5) , (7, 1)
// ...
// 결과 -> (2, 5), (7, 1), (3, 4, 8), (6), (9, 3)
public class B2229_조짜기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                max = Math.max(max, Math.abs(arr[i] - arr[j]) + dp[j - 1]);
            }

            dp[i] = max;
        }

        System.out.println(dp[n]);
    }
}
