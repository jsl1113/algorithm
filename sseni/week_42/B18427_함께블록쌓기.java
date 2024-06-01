package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 한 명당 한개의 블록만 쌓을 수 있음, 블록을 쌓지 않아도 됨
public class B18427_함께블록쌓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][h + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i][0] = 1;

            int cnt = st.countTokens();
            for (int j = 0; j < cnt; j++) {
                int block = Integer.parseInt(st.nextToken());

                for (int k = block; k <= h; k++) {  // 블록부터 최대 높이까지 반복
                    dp[i][k] += dp[i - 1][k - block]; // k의 높이 기준, 블록 높이를 뺐을 때 가능한 경우의 수를 더해줌
                    dp[i][k] %= 10007;
                }
            }

            for (int k = 1; k <= h; k++) { // i 번째 학생 블록을 포함 안한다고 생각했을 때
                dp[i][k] += dp[i - 1][k]; // 이전 경우의 수를 더해줌
                dp[i][k] %= 10007;
            }
        }

        System.out.println(dp[n][h]);
    }
}
