package com.example.algorithm.study.review.week16_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 플로이드 와샬
// 0: 집, n+1: 페스티벌
// 1박스에 최대 20병, 1병당 50미터
public class RV_B9205_맥주마시면서걸어가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Point[] arr = new Point[n + 2];
            boolean[][] visited = new boolean[n + 2][n + 2];

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[i] = new Point(x, y);
            }

            for (int i = 0; i < n + 2; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    if (getDistance(arr[i], arr[j]) <= 1000) {
                        visited[i][j] = true;
                        visited[j][i] = true;
                    }
                }
            }

            for (int k = 0; k < n + 2; k++) {
                for (int i = 0; i < n + 2; i++) {
                    for (int j = 0; j < n + 2; j++) {
                        if (visited[i][k] && visited[k][j]) {
                            visited[i][j] = true;
                        }
                    }
                }
            }

            sb.append(visited[0][n + 1] ? "happy" : "sad").append("\n");
        }
        System.out.println(sb);
    }

    static int getDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
