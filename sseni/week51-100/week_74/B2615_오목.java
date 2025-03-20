package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오른쪽, 아래, 오른쪽대각선, 왼쪽대각선
public class B2615_오목 {
    static int[][] arr = new int[19][19];
    static final int[] dx = {0, 1, 1, 1};
    static final int[] dy = {1, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (arr[i][j] != 0) {
                    int color = arr[i][j];

                    for (int d = 0; d < 4; d++) {
                        if (check(i, j, dx[d], dy[d], color)) {
                            int finalX = (d == 3) ? i + 4 : i;
                            int finalY = (d == 3) ? j - 4 : j;

                            System.out.println(color);
                            System.out.println((finalX + 1) + " " + (finalY + 1));
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    static boolean check(int x, int y, int dx, int dy, int color) {
        int cnt = 1;

        for (int i = 1; i <= 5; i++) {
            int nx = x + dx * i;
            int ny = y + dy * i;

            if (isValid(nx, ny) && arr[nx][ny] == color) cnt++;
            else break;
        }

        if (cnt == 5) {
            int prevX = x - dx;
            int prevY = y - dy;
            int nextX = x + dx * 5;
            int nextY = y + dy * 5;

            if ((!isValid(prevX, prevY) || arr[prevX][prevY] != color) &&
                    (!isValid(nextX, nextY) || arr[nextX][nextY] != color)) {
                return true;
            }
        }

        return false;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < 19 && y >= 0 && y < 19;
    }
}
