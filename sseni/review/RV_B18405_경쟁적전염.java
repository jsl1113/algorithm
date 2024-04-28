package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 팁: List<Queue<int[]>> 로 하면 시간초과나요
public class RV_B18405_경쟁적전염 {
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<int[]>[] queue = new LinkedList[k + 1];
        for (int i = 0; i <= k; i++) {
            queue[i] = new LinkedList<>();
        }

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] > 0) {
                    queue[arr[i][j]].add(new int[]{i, j, 0});
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        int time = 0;
        while (time < s) {
            for (int i = 1; i <= k; i++) {
                while (!queue[i].isEmpty()) {
                    if (queue[i].peek()[2] == time) {
                        int[] tmp = queue[i].poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = tmp[0] + dx[d];
                            int ny = tmp[1] + dy[d];

                            if(nx >= n || ny >= n || nx < 0 || ny < 0) continue;
                            if(arr[nx][ny] > 0) continue;

                            arr[nx][ny] = i;
                            queue[i].add(new int[]{nx, ny, tmp[2] + 1});
                        }
                    } else break;
                }
            }
            time++;
        }

        System.out.println(arr[x][y]);
    }
}
