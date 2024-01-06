package com.example.algorithm.study.week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15900_나무탈출 {
    static List<Integer>[] lists;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        lists = new List[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }

        dfs(1, 0);
        System.out.println(answer % 2 == 0 ? "No" : "Yes");
    }

    static void dfs(int current, int cnt) {
        visited[current] = true;

        for (int i = 0; i < lists[current].size(); i++) {
            if (!visited[lists[current].get(i)]) {
                dfs(lists[current].get(i), cnt + 1);
            }
        }

        if (lists[current].size() == 1) answer += cnt;
    }
}
