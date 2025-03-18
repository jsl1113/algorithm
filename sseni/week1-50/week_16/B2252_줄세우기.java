package com.example.algorithm.study.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2252_줄세우기 {
    static int n, m;
    static List<Integer>[] list;
    static Stack<Integer> stack = new Stack<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void solution() {
        for (int i = 1; i <= n; i++) {
            if(!visited[i]) {
                dfs(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }

        System.out.println(sb);
    }

    static void dfs(int num) {
        visited[num] = true;
        for (int next : list[num]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
        stack.add(num);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
        }
    }
}
