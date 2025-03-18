package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs 인데 구현을 곁들인
public class B16928_뱀과사다리게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[101];
        boolean[] visited = new boolean[101];
        int[] answer = new int[101];

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u] = v;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        answer[1] = 0;
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == 100) {
                System.out.println(answer[current]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = current + i;

                if(100 < next || visited[next]) continue;

                if (arr[next] != 0) {
                    if (!visited[arr[next]]) {
                        visited[arr[next]] = true;
                        answer[arr[next]] = answer[current] + 1;
                        queue.add(arr[next]);
                    }
                } else {
                    visited[next] = true;
                    answer[next] = answer[current] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
