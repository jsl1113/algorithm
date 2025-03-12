package com.example.algorithm.study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16439 {
    static int n, m, satisfaction; // 고리 회원 수, 치킨 종류 수
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        satisfaction = Integer.MIN_VALUE;

        arr = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, new ArrayList<>());
        System.out.println(satisfaction);
    }

    public static void dfs(int cnt, int start, List<Integer> list) {
        if (cnt == 3) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {  // n명을 순회하며
                int max = 0;
                for (int j = 1; j <= 3; j++)  // 각 치킨에 대한 선호도 최댓값을 찾아 sum 에 더해줌
                    max = Math.max(arr[i][list.get(j - 1)], max);
                sum += max;
            }
            satisfaction = Math.max(satisfaction, sum);
            return;
        }

        for (int i = start; i <= m; i++) {
            list.add(i);
            dfs(cnt + 1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
