package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B15663_N과M_9 {
    static int n, m, arr[];
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        visited = new boolean[n];
        sb = new StringBuilder();
        dfs(0, new ArrayList<>());
        System.out.println(sb);
    }

    static void dfs(int cnt, List<Integer> list){
        if (cnt == m) {
            for (int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        int tmp = -1;
        for (int i = 0; i < n; i++) {
            int current = arr[i];

            if (!visited[i] && current != tmp) {
                tmp = current;
                visited[i] = true;
                list.add(arr[i]);
                dfs(cnt + 1, list);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
