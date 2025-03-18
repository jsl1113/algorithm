package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 대각선 포함 모든 방향으로 원하는 만큼 이동
// 이미 배치된 queen 과 겹치지 않는 위치를 찾아가야 함
public class B9663_NQueen {
    static int n, cnt = 0, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        dfs(0);
        System.out.println(cnt);
    }

    static void dfs(int y) {
        if (y == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[y] = i;

            if (check(y)) {
                dfs(y + 1);
            }
        }
    }

    static boolean check(int y) {
        for (int x = 0; x < y; x++) {
            if (arr[x] == arr[y]) {
                // 행 확인
                return false;
            } else if (Math.abs(y - x) == Math.abs(arr[y] - arr[x])) {
                // 대각선 확인, 행의 차이와 열의 차이가 같다 = 같은 대각선
                return false;
            }
        }

        return true;
    }
}
