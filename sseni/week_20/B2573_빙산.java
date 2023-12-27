package com.example.algorithm.study.week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2573_빙산 {
    static int n, m;
    static int[][] arr, cnt;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        cnt = new int[n][m];
        int answer = 0;
        while (true) {
            // 빙산 덩어리 카운트
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && arr[i][j] != 0) {
                        dfs(i, j);
                        tmp++;
                    }
                }
            }

            if (tmp == 0) {
                System.out.println(0);
                return;
            } else if (tmp >= 2) {
                System.out.println(answer);
                return;
            }

            // 빙산 녹이기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] -= cnt[i][j]; // 0 개수만큼 줄어듦
                    if(arr[i][j] < 0) arr[i][j] = 0;

                    // 초기화
                    visited[i][j] = false;
                    cnt[i][j] = 0;

                }
            }
            answer++;
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
            if(arr[nx][ny] == 0) cnt[x][y]++; // 0이 저장된 칸의 개수 카운트
            else dfs(nx, ny);
        }
    }
}
