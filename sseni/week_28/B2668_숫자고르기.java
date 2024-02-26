package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 처음엔 비트마스킹으로 부분집합을 생각했다가, n<=100 을 보고 포기
// (1, 3) 과 (5) 같은 싸이클이 중요
public class B2668_숫자고르기 {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int num : list) {
            System.out.println(num);
        }
    }

    static void dfs(int idx, int end) {
        if (arr[idx] == end) {
            list.add(idx);
            return;
        }

        if (!visited[arr[idx]]) {
            visited[arr[idx]] = true;
            dfs(arr[idx], end);
            visited[arr[idx]] = false;
        }
    }
}
