package com.example.algorithm.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RV_B9663_NQueen {
    static int N, cnt, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        dfs(0);
        System.out.println(cnt);
    }

    static void dfs(int idx) {
        if (idx == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[idx] = i;

            if (check(idx)) {
                dfs(idx + 1);
            }
        }
    }

    static boolean check(int col) {
        for (int i = 0; i < col; i++) {
            if(arr[col] == arr[i]) {
                return false;
            }
            if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
