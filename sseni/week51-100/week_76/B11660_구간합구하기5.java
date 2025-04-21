package com.example.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B11660_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = board[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(reader.readLine());
            int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
            sb.append(dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]).append('\n');
        }

        System.out.print(sb);
    }
}
