package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4963_섬의개수 {
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1}, dy = {0, 0, 1, -1, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            int[][] arr = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            boolean[][] visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i, j});
                        visited[i][j] = true;

                        while (!queue.isEmpty()) {
                            int[] p = queue.poll();

                            for (int d = 0; d < 8; d++) {
                                int nx = p[0] + dx[d];
                                int ny = p[1] + dy[d];

                                if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                                if(arr[nx][ny] == 0 || visited[nx][ny]) continue;

                                visited[nx][ny] = true;
                                queue.add(new int[]{nx, ny});
                            }
                        }

                        answer++;
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
