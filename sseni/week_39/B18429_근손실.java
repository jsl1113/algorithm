package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B18429_근손실 {
    static int n, k, answer = 0;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n];
        dfs(0, new ArrayList<>());

        System.out.println(answer);
    }

    static void dfs(int cnt, List<Integer> list) {
        if (cnt == n) {
            if(solution(list)) answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(i);
                dfs(cnt + 1, list);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    static boolean solution(List<Integer> list) {
        int num = 500;

        for (int idx : list) {
            num += arr[idx];
            num -= k;

            if(num < 500) return false;
        }

        return true;
    }
}

