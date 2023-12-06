package com.example.algorithm.study.week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 7명, S 가 최소 4명 이상이고, 가로나 세로로 인접해있어야 함
// 1. 7자리를 뽑기 (points) & S가 4개 이상인지 확인
// 2. 연결되어 있는 자리인지 확인 후 카운트
public class B1941_소문난칠공주 {
    static char[][] arr = new char[5][5];
    static Point[] points = new Point[7];
    static int answer = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    static void dfs(int cnt, int start, int y) {
        if (y > 3) return;
        if (cnt == 7) {
            boolean[][] map = new boolean[5][5];
            for (int i = 0; i < 7; i++) {
                Point p = points[i];
                map[p.x][p.y] = true;
            }

            answer += (bfs(map) == 7) ? 1 : 0;
            return;
        }

        for (int i = start; i < 25; i++) {
            points[cnt] = new Point(i / 5, i % 5);
            dfs(cnt + 1, i + 1, arr[i / 5][i % 5] == 'Y' ? y + 1 : y);
            points[cnt] = null;
        }
    }

    static int bfs(boolean[][] map) {
        int cnt = 1;

        boolean[][] visited = new boolean[5][5];
        Queue<Point> queue = new LinkedList<>();
        queue.add(points[0]);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            visited[p.x][p.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny]) continue;
                if(!map[nx][ny]) continue;
                cnt++;
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }

        return cnt;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
