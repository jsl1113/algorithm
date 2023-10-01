package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RV_B1325_효율적인해킹 {
    static ArrayList<Integer>[] arrayLists;
    static int n, m;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayLists[a].add(b);
        }

        result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int computer = queue.poll();
                for (int next : arrayLists[computer]) {
                    if (!visited[next]) {
                        result[next]++;
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, result[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
}
