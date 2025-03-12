package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B6603_로또 {
    static int n, arr[], answer[];
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());

            if(n == 0) {
                System.out.println(sb);
                return;
            }

            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[n];
            answer = new int[6];
            dfs(0, 0);

            sb.append("\n");
        }
    }

    static void dfs(int start, int idx) {
        if (idx == 6) {
            for(int num : answer){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                answer[idx] = arr[i];

                visited[i] = true;
                dfs(i, idx + 1);
                visited[i] = false;
            }
        }
    }
}
