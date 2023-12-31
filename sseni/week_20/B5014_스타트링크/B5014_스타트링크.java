package com.example.algorithm.study.week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5014_스타트링크 {
    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = -Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[F + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{S, 0});
        visited[S] = true;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            if (arr[0] == G) {
                System.out.println(arr[1]);
                return;
            }

            for (int n : new int[]{U, D}) {
                int next = arr[0] + n;
                if (next > F || next < 1) continue;
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, arr[1] + 1});
                }
            }
        }
        System.out.println("use the stairs");
    }
}
