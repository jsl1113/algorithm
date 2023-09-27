package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RV_B15652 {
    static StringBuilder sb;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        dfs(0, 1, new ArrayList<>());
        System.out.println(sb);
    }

    public static void dfs(int cnt, int start, List<Integer> list) {
        if (cnt == m) {
            for (int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(cnt + 1, i, list);
            list.remove(list.size() - 1);
        }
    }
}
