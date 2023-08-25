package com.example.algorithm.study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class B15650 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(0, 1, new ArrayList<>());
    }

    public static void dfs(int cnt, int start, List<Integer> list) {
        if (cnt == m) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(cnt + 1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
