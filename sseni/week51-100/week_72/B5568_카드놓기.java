package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class B5568_카드놓기 {
    static int n, k, arr[];
    static boolean visited[];
    static HashSet<String> hs = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[n];
        dfs("", 0);
        System.out.println(hs.size());
    }

    static void dfs(String str, int cnt) {
        if (cnt == k) {
            hs.add(str);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(str + String.valueOf(arr[i]), cnt + 1);
                visited[i] = false;
            }
        }
    }
}
