package com.example.algorithm.study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 처음에 1 인 곳이 한 곳만 있는줄 알고 한 곳만 저장했다가 틀려서
// 애초에 입력했을 때부터 1인 곳을 큐에 넣어주도록 변경했다.
public class B7576 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] strArray = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(strArray[j]);

                if (arr[i][j] == 1) { // 익은 토마토라면 큐에 저장
                    queue.add(new int[]{i, j});
                }
            }
        }

        boolean[][] visited = new boolean[n][m];
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && arr[nx][ny] == 0) {
                    arr[nx][ny] = arr[x][y] + 1;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) { // 0 이 하나라도 있으면 모두 익지 않았다
                    System.out.println(-1);
                    return;
                }
            }
        }

        int day = 0;
        for (int i = 0; i < n; i++) {
            day = Math.max(Arrays.stream(arr[i]).max().getAsInt(), day);
        }

        System.out.println(day - 1);  // 처음 상태값도 더해져 있기 때문에 -1
    }
}