package com.example.algorithm.study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B15654 {
    static int n, m;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        boolean[] visited = new boolean[n];
        dfs(0, new ArrayList<>(), visited);
        System.out.println(sb.toString());
    }

    public static void dfs(int cnt, List<Integer> list, boolean[] visited) {
        if (cnt == m) {
            for (int num : list) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                list.add(arr[i]);
                visited[i] = true;
                dfs(cnt + 1, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
