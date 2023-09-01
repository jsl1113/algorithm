package com.example.algorithm.study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15652 {
    static int n, m;
    static StringBuilder sb;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        list = new ArrayList<>();

        dfs(0,1);
        System.out.println(sb.toString());
    }

    public static void dfs(int cnt, int idx) {
        if (cnt == m) {
            for(int num : list) sb.append(num + " ");
            sb.append("\n");
            return;
        }

        for (int i = idx; i <= n; i++) {
            list.add(i);
            dfs(cnt + 1, i);
            list.remove(list.size() - 1);
        }
    }

}
