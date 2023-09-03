package com.example.algorithm.study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 아 dfs 치킨 집 좌표 출력했을 때 중복 제거해야 한다는 걸 눈치챘어야 했는데
// 순열이 아니라 조합. 
// 기억하자
public class RV_B15686 {
    static int n, m, dis;
    static List<Point> house;
    static List<Point> chicken;
    static int[][] cities;
    static boolean[] isVisited;

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        cities = new int[n][n];
        dis = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                cities[i][j] = Integer.parseInt(tmp[j]);
                if(cities[i][j] == 1) house.add(new Point(i, j));
                if(cities[i][j] == 2) chicken.add(new Point(i, j));
            }
        }

        isVisited = new boolean[chicken.size()];
        if(chicken.size() == m) {
            dis = getDistance(chicken);
        }
        else {
            dfs(0, 0, new ArrayList<>());
        }

        System.out.println(dis);
    }

    public static void dfs(int cnt, int start, List<Point> list) {
        if (cnt == m) {
            dis = Math.min(getDistance(list), dis);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if(!isVisited[i]){
                isVisited[i] = true;
                list.add(chicken.get(i));
                dfs(cnt + 1, i, list);
                isVisited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static int getDistance(List<Point> list) {
        int distance = 0;
        for (Point h : house) {
            int d = Integer.MAX_VALUE;
            for (Point c : list) {
                d = Math.min(d, Math.abs(h.x - c.x) + Math.abs(h.y - c.y));
            }
            distance += d;
        }
        return distance;
    }

}
