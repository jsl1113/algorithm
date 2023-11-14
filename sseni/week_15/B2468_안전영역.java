package com.example.algorithm.study.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1 ~ max 까지 물에 잠기고 나서 안전 영역 개수 갱신하기
// 아무 지역도 물에 잠기지 않을 수도 있다 -> num을 0부터 시작했어야 했다
public class B2468_안전영역 {
    static int n, max = 0;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    static int solution() {
        int answer = Integer.MIN_VALUE;

        for (int num = 0; num <= max; num++) {
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
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    static void dfs(int x, int y, int num) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || arr[nx][ny] <= num)
                continue;
            dfs(nx, ny, num);
        }
    }

    static void init() throws IOException {
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
    }
}
