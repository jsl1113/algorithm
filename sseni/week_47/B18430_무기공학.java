package com.example.algorithm;

import java.util.*;
import java.io.*;

public class B18430_무기공학 {
    static int n, m, max;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] dx = {{0, 1}, {0, 1}, {-1, 0}, {-1, 0}};
    static int[][] dy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }

    static void dfs(int tmp, int sum) {
        if (tmp == n * m) {
            max = Math.max(max, sum);
            return;
        }

        int tx = tmp / m;
        int ty = tmp % m;

        if (!visited[tx][ty]) {
            for (int d = 0; d < 4; d++) {
                //부메랑 모양 가능한지 체크
                int x1 = tx + dx[d][0];
                int x2 = tx + dx[d][1];
                int y1 = ty + dy[d][0];
                int y2 = ty + dy[d][1];

                if (check(x1, x2, y1, y2)) {
                    visited[tx][ty] = true;
                    visited[x1][y1] = true;
                    visited[x2][y2] = true;
                    dfs(tmp + 1, sum + (arr[tx][ty] * 2) + arr[x1][y1] + arr[x2][y2]);
                    visited[tx][ty] = false;
                    visited[x1][y1] = false;
                    visited[x2][y2] = false;
                }
            }
        }

        dfs(tmp + 1, sum);
    }

    static boolean check(int x1, int x2, int y1, int y2) {
        if (x1 < 0 || x2 < 0 || x1 >= n || x2 >= n) return false;
        if (y1 < 0 || y2 < 0 || y1 >= m || y2 >= m) return false;
        if (visited[x1][y1]) return false;
        if (visited[x2][y2]) return false;

        return true;
    }
}
