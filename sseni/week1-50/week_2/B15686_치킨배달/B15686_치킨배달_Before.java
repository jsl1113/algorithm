package com.example.algorithm.study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/15686
public class B15686_Before {
    public static class Point {
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, distance;
    static int[][] city;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        city = new int[n][n];
        List<Point> chicken = new ArrayList<>();
        List<Point> house = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(tmp[j]);
                if(city[i][j] == 2) chicken.add(new Point(i, j));
                if(city[i][j] == 1) house.add(new Point(i, j));
            }
        }

        Map<Point, Boolean> map = new HashMap<>();
        for(int i=0; i<chicken.size(); i++) map.put(chicken.get(i), false);

        distance = Integer.MAX_VALUE;
        dfs(house, chicken, map);
        System.out.println(distance);
    }

    public static void dfs(List<Point> house, List<Point> chicken, Map<Point, Boolean> map) {
        if(chicken.size() == m){
            distance = Math.min(distance, getChickenStreet(house, chicken));
            return;
        }

        // 거의 다 푼 문제, 아쉽다
        // 나는 치킨집 전체에서 하나씩 제거해가며 m 개수에 맞춰서 경우의 수 계산
        // ex. 13개 중에 2개 뽑기
        // 11개를 제거해야 하니 비효율적, 2개씩 골라서 경우의 수 계산해나가야 한다.
        // 또한, 내가 한 방식은 순열. -> 조합으로 변경해야 한다.
        for (int i = 0; i < chicken.size(); i++) {
            if (!map.get(chicken.get(i))) {
                Point p = chicken.get(i);
                chicken.remove(p);
                map.put(p, true);
                dfs(house, chicken, map);
                chicken.add(p);
                map.put(p, false);
            }
        }
    }

    public static int getChickenStreet(List<Point> house, List<Point> chicken) {
        int dis = 0;

        // 이 도시의 치킨 거리 구하기
        for(Point h : house){
            int minNum = Integer.MAX_VALUE;
            for(Point c : chicken){
                minNum = Math.min(Math.abs(h.x - c.x) + Math.abs(h.y - c.y), minNum);
            }
            dis += minNum;
        }
        return dis;
    }
}
