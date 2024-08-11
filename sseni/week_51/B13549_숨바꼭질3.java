package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B13549_숨바꼭질3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100_001];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});

        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            visited[point[0]] = true;

            if (point[0] == k) answer = Math.min(answer, point[1]);

            int a = point[0] - 1, b = point[0] + 1, c = 2 * point[0];
            if (a >= 0 && !visited[a]) queue.add(new int[]{a, point[1] + 1});
            if(b <= 100_000 && !visited[b]) queue.add(new int[]{b, point[1] + 1});
            if(c <= 100_000 && !visited[c]) queue.add(new int[]{c, point[1]});
        }

        System.out.println(answer);
    }
}
