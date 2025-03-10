package com.example.algorithm.study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B11725_DFS {
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

        dfs(list, parent, visited, 1);  // 1번 노드로 시작해서,

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(List<List<Integer>> list, int[] parent, boolean[] visited, int node) {
        visited[node] = true; // 해당 노드를 방문했다고 체크

        for (int child : list.get(node)) { // 해당 노드들의 자식 노드들을 반복해서
            if (!visited[child]) { // 방문하지 않은 노드일 경우
                parent[child] = node; // 해당 노드를 부모 노드로 설정 후
                dfs(list, parent, visited, child); // 자식 노드에 대해 dfs 재귀 호출
            }
        }
    }
}
