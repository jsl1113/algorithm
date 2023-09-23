package com.example.algorithm.study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// DFS 와 동일한 흐름
public class B11725_BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }

        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int v : list.get(node)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                    parent[v] = node;
                }
            }
        }

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }
}
