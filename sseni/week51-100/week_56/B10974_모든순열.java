package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B10974_모든순열 {
    static int n, arr[];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        dfs(0, new ArrayList<>());
    }

    static void dfs(int cnt, List<Integer> list) {
        if (cnt == n) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                dfs(cnt + 1, list);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
