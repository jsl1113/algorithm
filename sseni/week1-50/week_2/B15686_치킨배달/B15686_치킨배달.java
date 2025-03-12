package com.example.algorithm.study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/15686
public class B15686 {
    /*
            n : 도시 크기
            m : 최대 m개의 치킨집 개수
            distance : 도시의 치킨 거리의 최솟값
            isVisit : 치킨집 방문 처리 배열
            chicken : 치킨집 위치 리스트
            house : 집 위치 리스트
    */
    static int n, m, distance;
    static boolean[] isVisit;

    public static class Point {
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Point> chicken = new ArrayList<>();
        List<Point> house = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(tmp[j]);
                if(num == 2) chicken.add(new Point(i, j));
                if(num == 1) house.add(new Point(i, j));
            }
        }

        distance = Integer.MAX_VALUE;
        isVisit = new boolean[chicken.size()];
        dfs(0, 0, chicken, house);
        System.out.println(distance);
    }

    public static void dfs(int start, int cnt, List<Point> chicken, List<Point> house) {
        if(cnt == m){
            distance = Math.min(distance, getChickenStreet(chicken, house));
            return;
        }

        // (수정) 0개부터 시작해서 m개만큼 조합하여 경우의 수 계산
        for (int i = start; i < chicken.size(); i++) {
            isVisit[i] = true;
            dfs(i + 1, cnt + 1, chicken, house);
            isVisit[i] = false;
        }
    }

    public static int getChickenStreet(List<Point> chicken, List<Point> house) {
        int dis = 0;

        // 이 도시의 치킨 거리 구하기
        for(Point h : house){
            int minNum = Integer.MAX_VALUE;
            for (int i = 0; i < chicken.size(); i++) {
                if(isVisit[i]) minNum = Math.min(Math.abs(h.x - chicken.get(i).x) + Math.abs(h.y - chicken.get(i).y), minNum);
            }
            dis += minNum;
        }
        return dis;
    }
}
