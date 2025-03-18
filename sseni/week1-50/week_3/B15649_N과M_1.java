package com.example.algorithm.study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B15649 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        Boolean[] visited = new Boolean[n + 1];
        Arrays.fill(visited, false);
        dfs(0, list, visited);
    }

    public static void dfs(int cnt, List<Integer> list, Boolean[] visited) {
        if (cnt == m) {
            for (int i = 0; i < list.size(); i++){
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                list.add(i);
                visited[i] = true;
                dfs(cnt + 1, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
