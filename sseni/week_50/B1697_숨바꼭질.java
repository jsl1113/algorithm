package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];
        int[] dist = new int[100001];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur + 1 <= 100000) {
                if (!visited[cur + 1]) {
                    dist[cur + 1] = dist[cur] + 1;
                    queue.offer(cur + 1);
                    visited[cur + 1] = true;
                }
            }
            if (cur - 1 >= 0) {
                if (!visited[cur - 1]) {
                    dist[cur - 1] = dist[cur] + 1;
                    queue.offer(cur - 1);
                    visited[cur - 1] = true;
                }
            }
            if (cur * 2 <= 100000) {
                if (!visited[cur * 2]) {
                    dist[cur * 2] = dist[cur] + 1;
                    queue.offer(cur * 2);
                    visited[cur * 2] = true;
                }
            }
        }

        System.out.println(dist[k]);
    }
}
