package com.example.algorithm.study.week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 적록색약 = R G 차이 못 느낌 = G to R
// 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다.
public class B10026_적록색약 {
    static int[] dx = {1,-1,0,0}, dy = {0, 0, -1, 1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = tmp[j];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bfs(new boolean[n][n], arr)).append(" ");
        changeGtoR(arr);
        sb.append(bfs(new boolean[n][n], arr));

        System.out.println(sb);
    }

    static void changeGtoR(char[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 'G') arr[i][j] = 'R';
            }
        }
    }

    static int bfs(boolean[][] visited, char[][] arr) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    char color = arr[i][j];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] point = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = point[0] + dx[d];
                            int ny = point[1] + dy[d];

                            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if(visited[nx][ny] || arr[nx][ny] != color) continue;

                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
