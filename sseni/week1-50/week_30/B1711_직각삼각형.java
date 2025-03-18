package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 범위가 크고, 많았기 때문에 넓이를 계산하는 데 Math 함수나
// 제일 긴 길이를 구하려다보니 시간초과가 났다
// 굳이 제일 큰 길이를 구할 필요 없이, 세 가지 케이스 중 하나라도 같으면 된다는 것
public class B1711_직각삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    if (check(list.get(i), list.get(j), list.get(k))) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static boolean check(Point p1, Point p2, Point p3) {
        long x = getDistance(p1, p2);
        long y = getDistance(p1, p3);
        long z = getDistance(p2, p3);

        if (x + y == z || y + z == x || x + z == y) return true;
        else return false;
    }

    static long getDistance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
