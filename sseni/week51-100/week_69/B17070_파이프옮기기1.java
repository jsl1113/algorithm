package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 0 가로, 1 세로, 2 대각선
public class B17070_파이프옮기기1 {
    static boolean[][] arr;
    static int n, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                if (st.nextToken().equals("1")) {
                    arr[i][j] = true;
                }
            }
        }

        dfs(0, 1, 0);
        System.out.println(answer);
    }

    static void dfs(int x, int y, int d) {
        if (x == n - 1 && y == n - 1) {
            answer++;
            return;
        }

        switch (d) {
            case 0 -> {
                if (y + 1 < n && !arr[x][y + 1]) dfs(x, y + 1, 0);
            }
            case 1 -> {
                if (x + 1 < n && !arr[x + 1][y]) dfs(x + 1, y, 1);
            }
            case 2 -> {
                if (y + 1 < n && !arr[x][y + 1]) dfs(x, y + 1, 0);
                if (x + 1 < n && !arr[x + 1][y]) dfs(x + 1, y, 1);
            }
        }

        if (x + 1 < n && y + 1 < n && !arr[x][y + 1] && !arr[x + 1][y] && !arr[x + 1][y + 1]) {
            dfs(x + 1, y + 1, 2);
        }
    }
}
