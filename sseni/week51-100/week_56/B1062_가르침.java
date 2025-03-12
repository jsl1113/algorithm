package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1062_가르침 {
    static int N, K;
    static String[] arr;
    static boolean[] visited;

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temps = br.readLine().split(" ");
        N = Integer.parseInt(temps[0]);
        K = Integer.parseInt(temps[1]);

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        arr = new String[N];
        visited = new boolean[26];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            arr[i] = temp.substring(4, temp.length() - 4);
        }

        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        dfs(5, 0);
        System.out.println(result);
    }

    static void dfs(int depth, int idx) {
        if (depth == K) {
            check();
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }
    }

    private static void check() {
        int canReadStrCnt = 0;

        for (int i = 0; i < N; i++) {
            int len = arr[i].length();

            boolean canRead = true;
            for (int j = 0; j < len; j++) {
                if (!visited[arr[i].charAt(j) - 'a']) {
                    canRead = false;
                    break;
                }
            }
            if (canRead) canReadStrCnt++;
        }
        result = Math.max(result, canReadStrCnt);
    }
}
