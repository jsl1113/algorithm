package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10655_마라톤1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Point[] arr = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Point(x, y);
        }

        int total = 0;
        for (int i = 0; i < n - 1; i++) {
            total += getDistance(arr[i], arr[i + 1]);
        }

        int answer = total;
        for (int i = 1; i < n - 1; i++) {
            int tmp = total
                    - getDistance(arr[i - 1], arr[i])
                    - getDistance(arr[i], arr[i + 1])
                    + getDistance(arr[i - 1], arr[i + 1]);
            answer = Math.min(answer, tmp);
        }

        System.out.println(answer);
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
