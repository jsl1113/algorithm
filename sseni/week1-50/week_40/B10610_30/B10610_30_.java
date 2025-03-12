package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 시간초과 
public class B10610_30_ {
    static int n, num = 0, answer = 0;
    static int[] arr;
    static List<Integer> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArray = br.readLine().split("");
        n = strArray.length;

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArray[i]);
        }

        list = new ArrayList<>();
        visited = new boolean[n];
        dfs(0);
        System.out.println(answer != 0 ? answer : -1);
    }

    static void dfs(int cnt) {
        if (cnt == n) {
            num = listToInt();

            if (num % 30 == 0) {
                answer = Math.max(answer, num);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                list.add(arr[i]);
                visited[i] = true;
                dfs(cnt + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    static int listToInt() {
        String s = "";
        for (int i : list) {
            s += String.valueOf(i);
        }

        return Integer.parseInt(s);
    }
}
