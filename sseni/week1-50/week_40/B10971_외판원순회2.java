package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10971_외판원순회2 {
    static int n, arr[][], answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0);
        }

        System.out.println(answer);
    }

    static void dfs(int start, int current, int cnt, int sum) {
        if (cnt == n - 1) {
            if (arr[current][start] != 0) {
                sum += arr[current][start];
                answer = Math.min(answer, sum);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visited[i] || arr[current][i] == 0) continue;

            visited[i] = true;
            dfs(start, i, cnt + 1, sum + arr[current][i]);
            visited[i] = false;
        }
    }
}
