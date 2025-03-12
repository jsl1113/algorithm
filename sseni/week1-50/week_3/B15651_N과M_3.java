package com.example.algorithm.study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15651 {
    static int n, m;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        List<Integer> list = new ArrayList<>();
        dfs(0, list);
        System.out.println(sb.toString());
    }

    public static void dfs(int cnt, List<Integer> list) {
        if (cnt == m) {
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i) + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            list.add(i);
            dfs(cnt + 1,  list);
            list.remove(list.size() - 1);
        }
    }
}
