package com.example.algorithm.study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 차례대로 큐에 넣고 꺼내면서 인접해있는지 판단하는 흐름은 기억이 났는데
// 막상 짜려니까 구조가 생각이 잘 안 났다.
public class B2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = true;
            arr[end][start] = true;
        }

        int answer = 0;
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 1; i <= n; i++) { // 이 부분이 기억 안 났음
                if(!visited[i] && arr[node][i]){
                    queue.add(i);
                    visited[i] = true;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
