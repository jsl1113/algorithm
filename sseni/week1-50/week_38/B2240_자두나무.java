package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이동하지 않고 그대로 두기 vs 이동해서 자두 하나 얻지 않기
// 이동해서 자두 하나 얻기 vs 이동하지 않고 자두를 얻지 않기
public class B2240_자두나무 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] dp = new int[t + 1][w + 1];  // t 미터에 w 만큼 이동했을 때

        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j <= w; j++) {
                if (j == 0) { // 한 번도 이동하지 않은 나무
                    dp[i][j] = (n == 1) ? dp[i - 1][j] + 1 : dp[i - 1][j];
                    continue;
                }

                if (j % 2 == 0) { // 떨어지는 위치가 2라면,
                    dp[i][j] = (n == 1) ?
                            Math.max(dp[i - 1][j - 1], dp[i - 1][j] + 1) :
                            Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = (n == 1) ?
                            Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]) :
                            Math.max(dp[i - 1][j - 1], dp[i - 1][j] + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= w; i++) {
            answer = Math.max(answer, dp[t][i]);
        }

        System.out.println(answer);
    }
}
