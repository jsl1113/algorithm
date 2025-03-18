package com.example.algorithm.study.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// BFS + 구현 문제 . .
// 처음엔 예제를 문제대로 따라하는 것 조차도 오래걸렸다 ...
public class B16236_아기상어 {
    static int n;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void solution() {
        int eat = 0, time = 0, age = 2;
        while (true) {
            ArrayList<Point> fish = new ArrayList<>(); // 먹을 수 있는 물고기 저장
            int[][] arr = new int[n][n];
            while (!queue.isEmpty()) {
                Point point = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = point.x + dx[i];
                    int ny = point.y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (arr[nx][ny] == 0 && map[nx][ny] <= age) {
                        arr[nx][ny] = arr[point.x][point.y] + 1;
                        queue.add(new Point(nx, ny, arr[nx][ny]));
                        if(map[nx][ny] >= 1 && map[nx][ny] <= 6 && map[nx][ny] < age) {
                            fish.add(new Point(nx, ny, arr[nx][ny]));
                        }
                    }
                }
            }

            // 먹을 수 있는 물고기가 없으면, 시간 리턴
            if (fish.size() == 0) {
                System.out.println(time);
                return;
            }

            Point p = fish.get(0);
            for (int i = 1; i < fish.size(); i++) {
                if (p.num > fish.get(i).num) {
                    p = fish.get(i);
                } else if (p.num == fish.get(i).num) {
                    if(p.x > fish.get(i).x) p = fish.get(i);
                    else if(p.x == fish.get(i).x && p.y > fish.get(i).y) p = fish.get(i);
                }
            }

            time += p.num;
            eat++;
            map[p.x][p.y] = 0;
            if(eat == age){  // 먹은 물고기 수가 나이와 같으면
                age++;
                eat = 0;
            }
            queue.add(new Point(p.x, p.y, 0));
        }
    }

    static class Point {
        int x, y, num;

        Point(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    queue.add(new Point(i, j, 0));
                    map[i][j] = 0;
                }
            }
        }
    }
}
