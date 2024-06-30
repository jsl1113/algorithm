package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2589_보물섬 {
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[][] arr = new char[L][W];
        for (int i = 0; i < L; i++) {
            String[] strArray = br.readLine().split("");

            for (int j = 0; j < W; j++) {
                arr[i][j] = strArray[j].charAt(0);
            }
        }

        int answer = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < W; j++) {
                if (arr[i][j] == 'L') {
                    boolean[][] visited = new boolean[L][W];
                    visited[i][j] = true;

                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j, 0});

                    int time = 0;
                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = current[0] + dx[d];
                            int ny = current[1] + dy[d];

                            if(nx < 0 || nx >= L || ny < 0 || ny >= W) continue;
                            if(visited[nx][ny] || arr[nx][ny] == 'W') continue;

                            queue.add(new int[]{nx, ny, current[2] + 1});
                            visited[nx][ny] = true;
                            answer = Math.max(answer, current[2] + 1);
                        }
                    }

                    answer = Math.max(time, answer);
                }
            }
        }

        System.out.println(answer);
    }
}
