package com.example.algorithm.study.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. dfs 로 올 수 있는 연산자 경우의 수를 탐색
// 2. 수식을 계산해서, 최댓값 / 최솟값 갱신
// op 배열이 visited 배열인 느낌으로다가 dfs 구현
public class B14888_연산자끼워넣기 {
    static int n;
    static int[] arr, op;
    static int[] answer = { Integer.MIN_VALUE, Integer.MAX_VALUE };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.toString(op));
        dfs(1, arr[0]);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    public static void dfs(int idx, int sum) {
        if (idx == n) {
            answer[0] = Math.max(answer[0], sum);
            answer[1] = Math.min(answer[1], sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                dfs(idx + 1, cal(sum, arr[idx], i));
                op[i]++;
            }
        }
    }

    public static int cal(int a, int b, int op) {
        int result = 0;
        switch (op) {
            case 0 -> result = a + b;
            case 1 -> result = a - b;
            case 2 -> result = a * b;
            case 3 -> result = a / b;
        }

        return result;
    }
}
