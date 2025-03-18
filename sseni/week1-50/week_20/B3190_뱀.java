package com.example.algorithm.study.week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 방향 전환할 때, d+1 든, d-1 든 d %= 4 라고 해줬었는데,
// arrayIndexOutOfBounds 에러가 계속 났다.
// 이유: -1%4 는 -1 이 나온다... (참고)
public class B3190_뱀 {
    static int n, k, l, arr[][];
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static HashMap<Integer, String> hm = new HashMap<>();
    static List<Point> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[a][b] = 1;
        }

        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            hm.put(a, s);
        }

        System.out.println(solution());
    }

    static int solution() {
        int answer = 0, d = 0;
        Point p = new Point(0, 0);
        list.add(p);
        while (true) {
            answer++;

            Point point = new Point(p.x + dx[d], p.y + dy[d]);
            if(isCheck(point)) break;

            list.add(point); // 몸 길이 늘리기
            if(arr[point.x][point.y] == 1) arr[point.x][point.y] = 0; // 사과 먹기
            else list.remove(0); // 몸 길이 줄이기

            if (hm.containsKey(answer)) {  // 방향 전환
                if (hm.get(answer).equals("D")) d = (d + 1 == 4) ? 0 : d + 1;
                else d = (d - 1 == -1) ? 3 : d - 1;
            }

            p = point;
        }

        return answer;
    }

    static boolean isCheck(Point p) {
        if(p.x < 0 || p.x >= n || p.y < 0 || p.y >= n) return true;
        for (Point point : list) {
            if (point.x == p.x && point.y == p.y) return true;
        }
        return false;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
