package com.example.algorithm.study.week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 인구이동 영역의 합계가 원하는대로 나오지 않아서 참고했다ㅠ
// 아쉽 풀 뻔
public class B16234_인구이동 {
    static int N, L, R, arr[][];
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            visited = new boolean[N][N];
            // for (int i = 0; i < N; i++) {
            //     System.out.println(Arrays.toString(arr[i]));
            // }
            // System.out.println();

            if (!check()) answer++;
            else break;
        }
        System.out.println(answer);
    }

    // 인구이동 필요 체크
    static boolean check() {
        List<int[]> list;
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    list = new LinkedList<>();
                    list.add(new int[]{i, j});
                    int sum = dfs(i, j, 0, list);

                    if (list.size() > 1) {
                        int avg = sum / list.size();
                        for (int[] point : list) {
                            arr[point[0]][point[1]] = avg;
                        }
                        flag = false;
                    }
                }
            }
        }
        return flag;
    }

    static int dfs(int x, int y, int sum, List<int[]> list) {
        visited[x][y] = true;
        sum = arr[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (visited[nx][ny] || !checkDiff(x, y, nx, ny)) continue;

            list.add(new int[]{nx, ny});
            sum += dfs(nx, ny, sum, list);
        }

        return sum;
    }

    static boolean checkDiff(int x, int y, int nx, int ny) {
        int diff = Math.abs(arr[x][y] - arr[nx][ny]);
        if (diff >= L && diff <= R) return true;
        else return false;
    }
}
