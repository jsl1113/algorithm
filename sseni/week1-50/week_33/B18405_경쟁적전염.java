package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B18405_경쟁적전염 {
    static int n, k, s, x, y;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Queue<int[]>[] queue = new LinkedList[k + 1];
        for (int i = 0; i <= k; i++) {
            queue[i] = new LinkedList<>();
        }

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > 0) {
                    queue[arr[i][j]].offer(new int[]{i, j, 0});
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken()) - 1;
        y = Integer.parseInt(st.nextToken()) - 1;

        int time = 0;
        while (time < s) {
            for (int i = 1; i <= k; i++) {
                while (!queue[i].isEmpty()) {
                    if (queue[i].peek()[2] == time) {
                        int[] p = queue[i].poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = p[0] + dx[d];
                            int ny = p[1] + dy[d];

                            if (nx >= n || ny >= n || nx < 0 || ny < 0) continue;
                            if (arr[nx][ny] > 0) continue;
                            arr[nx][ny] = i;
                            queue[i].offer(new int[]{nx, ny, p[2] + 1});
                        }
                    } else break;
                }
            }

            time++;
        }
        System.out.println(arr[x][y]);
    }
}
