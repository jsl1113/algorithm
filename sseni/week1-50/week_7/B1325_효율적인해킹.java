package com.example.algorithm.study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class B1325 {
    static int n, m;
    static boolean[] visited;
    static int maxCom = Integer.MIN_VALUE;
    static ArrayList<Integer>[] list;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            dfs(i);
//            bfs(i);
        }

        for (int i = 1; i <= n; i++) {
            maxCom = Math.max(maxCom, result[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(result[i] == maxCom){
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static void bfs(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for(int next : list[v]){
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    result[next]++;
                }
            }
        }
    }

    private static void dfs(int node){
        visited[node] = true;

        for (int next : list[node]) {
            if (!visited[next]) {
                result[next]++;
                dfs(next);
            }
        }
    }
}
