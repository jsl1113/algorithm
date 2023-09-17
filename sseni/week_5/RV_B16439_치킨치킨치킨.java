package com.example.algorithm.study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RV_B15661 {
    static int n, m, sum;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0, new ArrayList<>());
        System.out.println(sum);
    }

    public static void dfs(int start, int cnt, List<Integer> list) {
        if (cnt == 3) {
            sum = Math.max(sum, getSum(list));
            System.out.println(list);
            return;
        }

        for (int i = start; i <= m; i++) {
            list.add(i);
            dfs(i + 1, cnt + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static int getSum(List<Integer> list) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = 1; j <= m; j++) {
                if(list.contains(j)) {
                    tmp = Math.max(tmp, arr[i][j - 1]);
                }
            }
            answer += tmp;
        }
        return answer;
    }
}

