package com.example.algorithm.study.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1967_트리의지름 {
    static int n, max = 0, index = 0;
    static boolean[] visited;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[parent].add(new Node(child, weight));
            list[child].add(new Node(parent, weight));
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[n + 1];
        visited[index] = true;
        dfs(index, 0);

        System.out.println(max);
    }

    static void dfs(int idx, int weight) {
        if (max < weight) {
            max = weight;
            index = idx;
        }

        for (Node node : list[idx]) {
            if (!visited[node.idx]) {
                visited[node.idx] = true;
                dfs(node.idx, weight + node.weight);
            }
        }
    }

    static class Node {
        int idx, weight;

        Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }
}
