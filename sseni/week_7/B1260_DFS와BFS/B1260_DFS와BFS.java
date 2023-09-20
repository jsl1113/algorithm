package com.example.algorithm.study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 한 번 (바이러스 풀고) 손에 익으니까 금방 풀었다.
public class B1260 {
    static int n, m, v;
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        arr = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = true;
            arr[end][start] = true;
        }

        boolean[] visited = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        sb.append(v).append(" ");
        visited[v] = true;
        System.out.println(dfs(visited, v, sb));
        System.out.println(bfs());
    }

    public static String dfs(boolean[] visited, int v, StringBuilder sb) {
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && arr[v][i]) {
                sb.append(i).append(" ");
                visited[i] = true;
                dfs(visited, i, sb);
            }
        }
        return sb.toString();
    }

    public static String bfs() {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        StringBuilder sb = new StringBuilder();
        sb.append(v).append(" ");

        while (!queue.isEmpty()) {
            int point = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && arr[point][i]) {
                    queue.add(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }

        return sb.toString();
    }
}
