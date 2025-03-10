package com.example.algorithm.study.week16_30.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 부르는 숫자를 찾아 체크하기
// 빙고인지 체크하기
public class B2578_빙고 {
    static List<Point>[] lists = new List[26];
    static int[][] bingo = new int[5][5];
    static int[][] answer = new int[5][5];
    static boolean[][] visited = new boolean[5][5];

    public static void main(String[] args) throws IOException {
        init();

        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cnt++;
                int num = answer[i][j];
                Point p = lists[num].get(0);
                visited[p.x][p.y] = true;

                if (i > 0) {
                    if(check()) {
                        System.out.println(cnt);
                        return;
                    }
                }
            }
        }
    }

    static boolean check() {
        int cnt = 0; // 빙고 개수 카운트
        for (int i = 0; i < 5; i++) {
            int tmp = 0;
            for (int j = 0; j < 5; j++) {
                if (visited[i][j]) tmp++;
            }
            if (tmp == 5) cnt++;
        }


        for (int i = 0; i < 5; i++) {
            int tmp = 0;
            for (int j = 0; j < 5; j++) {
                if (visited[j][i]) tmp++;
            }
            if (tmp == 5) cnt++;
        }

        // 대각선 확인
        boolean b = true;
        for (int i = 0; i < 5; i++) {
            if (!visited[i][i]) {
                b = false;
                break;
            }
        }
        if(b) cnt++;

        b = true;
        for (int i = 0; i < 5; i++) {
            if (!visited[i][4 - i]) {
                b = false;
                break;
            }
        }
        if(b) cnt++;

        System.out.println(cnt);
        if (cnt >= 3) return true;
        else return false;
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i <= 25; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
                lists[bingo[i][j]].add(new Point(i, j));
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
