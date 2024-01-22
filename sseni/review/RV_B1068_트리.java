package com.example.algorithm.study.review.week16_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RV_B1068_트리 {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int answer = 0, deleteIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num == -1) {
                root = i;
            } else {
                arr[num].add(i);
            }
        }

        deleteIdx = Integer.parseInt(br.readLine());
        deleteNode(deleteIdx);
        dfs(root);
        System.out.println(answer);
    }

    static void deleteNode(int deleteIdx) {
        visited[deleteIdx] = true;

        for (int num : arr[deleteIdx]) {
            if (!visited[deleteIdx]) {
                deleteNode(num);
            }
        }
    }

    static void dfs(int idx) {
        int cnt = 0;
        if(visited[idx]) return;

        for (int num : arr[idx]) {
            if (!visited[num]) {
                dfs(num);
                cnt++;
            }
        }

        if (!visited[idx] && cnt == 0) {
            answer++;
        }
    }
}

