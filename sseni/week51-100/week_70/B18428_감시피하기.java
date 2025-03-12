package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18428_감시피하기 {
    static int n;
    static char[][] arr;
    static int dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0, 0);
        System.out.println(flag ? "YES" : "NO");
    }

    static void dfs(int idx, int cnt) {
        if (flag) return;
        if (cnt == 3) {
            if (check()) flag = true;
            return;
        }
        if (idx == n * n) return;

        int x = idx / n;
        int y = idx % n;

        if (arr[x][y] == 'X') {
            arr[x][y] = 'O';
            dfs(idx + 1, cnt + 1);
            arr[x][y] = 'X';
        }

        // 장애물 안 놓기
        dfs(idx + 1, cnt);
    }

    static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'T') {
                    for (int d = 0; d < 4; d++) {
                        int nx = i, ny = j;

                        while (true) {
                            nx += dx[d];
                            ny += dy[d];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] == 'O') break;
                            if (arr[nx][ny] == 'S') return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
