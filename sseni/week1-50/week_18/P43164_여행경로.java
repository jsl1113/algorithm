package com.example.algorithm.study.week_18;

import java.util.*;

public class P43164_여행경로 {
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] visited;

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(list);
        return list.get(0).split(" ");
    }

    static void dfs(int cnt, String str, String path, String[][] tickets) {
        if (cnt == tickets.length) {
            list.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (str.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(cnt + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}})));
        System.out.println(Arrays.toString(solution(new String[][]{
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}})));
    }
}
