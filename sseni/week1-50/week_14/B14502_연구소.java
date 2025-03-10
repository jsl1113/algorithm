package com.example.algorithm.study.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 벽 세울 세 곳 정하고 (DFS) 바이러스 퍼지고 나서(BFS) 최댓값 갱신 ?
// 처음에는 오래걸리지 않나 싶고 시간초과라고 생각했다, 이게 맞네..
public class B14502_연구소 {
    static int n, m, max = Integer.MIN_VALUE;
    static int[][] arr, virus;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);
    }

    static void dfs(int cnt) {  // 벽 세울 세 곳 정하기
        if (cnt == 3) {
            max = Math.max(max, bfs());
            return;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(cnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    static int bfs() {  // 바이러스 퍼트리고, 안전한 영역 크기 세기
        Queue<int[]> queue = new LinkedList<>();
        virus = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                virus[i][j] = arr[i][j];
                if(virus[i][j] == 2) queue.add(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx <= 0 || nx > n || ny <= 0 || ny > m) continue;
                if (virus[nx][ny] == 0) {
                    virus[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(virus[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }
}
