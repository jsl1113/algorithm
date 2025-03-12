package com.example.algorithm.study.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주사위가 이동했을 때 마다 상단에 쓰여 있는 값 구하기
// 이거 삼성 코테 기출 문제라던데 새삼 벽을 느낀다.
public class B14499_주사위굴리기 {
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};  // 상 하 좌 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice(0, 1, 2, 3, 4, 5);
        int[] arr = new int[6];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());

            int t = dice.top;
            int u = dice.up;
            int d = dice.down;
            int l = dice.left;
            int r = dice.right;
            int b = dice.bottom;

            Dice next;
            switch (num) {
                case 1 -> {
                    num = 3;
                    next = new Dice(l, u, d, b, t, r);
                }
                case 2 -> {
                    num = 1;
                    next = new Dice(r, u, d, t, b, l);
                }
                case 3 -> {
                    num = 0;
                    next = new Dice(u, b, t, l, r, d);
                }
                default -> {
                    num = 2;
                    next = new Dice(d, t, b, l, r, u);
                }

            }

            int nx = x + dx[num];
            int ny = y + dy[num];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

            dice = next;
            x = nx;
            y = ny;

            if (map[nx][ny] == 0) {
                map[nx][ny] = arr[next.bottom];
                System.out.println(arr[next.top]);
            } else {
                arr[next.bottom] = map[nx][ny];
                map[nx][ny] = 0;
                System.out.println(arr[next.top]);
            }
        }
    }

    static class Dice {
        int top, up, down, left, right, bottom;

        Dice(int top, int up, int down, int left, int right, int bottom) {
            this.top = top;
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
            this.bottom = bottom;
        }
    }
}

