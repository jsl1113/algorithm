package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B5567_결혼식 {
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }

        int answer = 0;
        visited = new boolean[n + 1];
        visited[1] = true;

        dfs(1, 0);

        for (boolean check : visited) {
            if (check) answer++;
        }

        System.out.println(answer - 1);
    }

    static void dfs(int num, int depth) {
        if (depth == 2) return;

        for (int i : list[num]) {
            visited[i] = true;
            dfs(i, depth + 1);
        }
    }
}
