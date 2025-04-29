package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 울타리(#) = -1, 늑대(v) = 2, 양(o) = 1
public class B3184_양 {
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == '#') arr[i][j] = -1;
                else if (str.charAt(j) == 'v') arr[i][j] = 2;
                else if (str.charAt(j) == 'o') arr[i][j] = 1;
            }
        }

        boolean[][] visited = new boolean[n][m];
        int s = 0, w = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != -1 && !visited[i][j]) {
                    visited[i][j] = true;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});

                    int sheep = 0, wolf = 0;
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();

                        if(arr[cur[0]][cur[1]] == 1) sheep++;
                        else if(arr[cur[0]][cur[1]] == 2) wolf++;
                        for (int d = 0; d < 4; d++) {
                            int nx = cur[0] + dx[d];
                            int ny = cur[1] + dy[d];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if(visited[nx][ny] || arr[nx][ny] == -1) continue;

                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }

                    if(sheep > wolf) s += sheep;
                    else w += wolf;
                }
            }
        }

        System.out.println(s + " " + w);
    }
}
