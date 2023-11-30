package com.example.algorithm.study.review.week16_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RV_B2468_안전영역 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n, max = 0, answer = 0;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        for (int i = 0; i <= max; i++) {
            answer = Math.max(solution(i), answer);
        }

        System.out.println(answer);
    }

    static int solution(int num) {
        int cnt = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] > num) {
                    dfs(i, j, num);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(int x, int y, int num) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(visited[nx][ny] || arr[nx][ny] <= num) continue;
            dfs(nx, ny, num);
        }
    }
}
