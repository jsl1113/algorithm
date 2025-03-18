package com.example.algorithm.study.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1 - 2, 3
// 2 - 7, 8, 9
// 4 - 5, 6
public class B2644_촌수계산 {
    static int n, m, x, y;
    static int[][] arr;
    static int[] answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        answer = new int[n + 1];
        dfs(x);
        System.out.println(answer[y] == 0 ? -1 :answer[y]);
    }

    static void dfs(int idx) {
        if (idx == y) return;

        for (int i = 1; i <= n; i++) {
            if (arr[idx][i] == 1 && answer[i] == 0) {
                answer[i] = answer[idx] + 1;
                dfs(i);
            }
        }
    }
}
