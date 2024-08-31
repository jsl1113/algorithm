package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20364_부동산다툼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = new int[q];
        for (int i = 0; i < q; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean[] visited = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int idx = arr[i];
            int answer = 0;

            while (idx != 0) {
                if(visited[idx]) {
                    answer = idx;
                }
                idx /= 2;
            }

            sb.append(answer).append("\n");

            if(answer == 0) {
                visited[arr[i]] = true;
            }
        }

        System.out.println(sb);
    }
}
