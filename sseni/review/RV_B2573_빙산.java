package com.example.algorithm.review.algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RV_B2573_빙산 {
    static int n, m;
    static int answer = 0;
    static int[][] arr, cnt;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        cnt = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
                Arrays.fill(cnt[i], 0);
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] > 0 && !visited[i][j]) {
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;

                        while (!queue.isEmpty()) {
                            int[] p = queue.poll();

                            for (int d = 0; d < 4; d++) {
                                int nx = p[0] + dx[d];
                                int ny = p[1] + dy[d];

                                if (check(nx, ny) && !visited[nx][ny] && arr[nx][ny] > 0) {
                                    queue.offer(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                }
                            }
                        }

                        count++;
                    }
                }
            }

            if (count > 1)
                break;
            else if (count == 0) {
                answer = 0;
                break;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] > 0) {
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];

                            if (check(nx, ny) && arr[nx][ny] < 1) {
                                cnt[i][j]++;
                            }
                        }
                    }

                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] -= cnt[i][j];
                }
            }

            answer++;
        }

        System.out.println(answer);
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}
