package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RV_B1967_트리의지름 {
    static int n, max = 0, idx = 0;
    static boolean[] visited;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        init();

        // 1번 기준, 제일 멀고, 가중치가 큰 것 => 9번 노드 (가중치: 28)
        visited = new boolean[n + 1];
        solution(visited, 1);

        //  idx 기준, 제일 멀고, 가중치가 큰 것 => 12번 노드 (가중치: 45)
        visited = new boolean[n + 1];
        solution(visited, idx);

        System.out.println(max);
    }

    static void solution(boolean[] visited, int index) {
        visited[index] = true;
        dfs(index, 0);
    }

    static void dfs(int index, int weight) {
        if(max < weight){
            max = weight;
            idx = index;
        }

        for (Node node : list[index]) {
            if (!visited[node.num]) {
                visited[node.num] = true;
                dfs(node.num, weight + node.weight);
            }
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, weight));
            list[b].add(new Node(a, weight));
        }
    }

    static class Node {
        int num, weight;

        Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }
}
