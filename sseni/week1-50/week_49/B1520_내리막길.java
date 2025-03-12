package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1520_내리막길 {
    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    static int n, m, arr[][], dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        dfs(0, 0);
        System.out.println(dp[0][0]);
    }

    static int dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) return 1;

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || arr[nx][ny] >= arr[x][y]) continue;
            if (dp[nx][ny] != -1) dp[x][y] += dp[nx][ny];
            else dp[x][y] += dfs(nx, ny);
        }

        return dp[x][y];
    }
}
