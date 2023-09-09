package com.example.algorithm.study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dp 문제들은 일단 dp 를 적용할 부분을 찾는 게 중요한 거 같다.
// 나는 일단 이전에 정사각형인지 계산했던 것을 어떻게 반영하지? 에서 실패했다.
// 중점은 1일 때만 계산, 현재 위치에서 좌, 우, 대각선 중 가장 작은 값 + 1 이 가장 큰 정사각형의 크기라는 것 ?
public class B1915 {
    static int n, m, maxNum;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        maxNum = 0;

        for (int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i - 1][j - 1] != 0) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxNum = Math.max(maxNum, dp[i][j]);
                }
            }
        }
        System.out.println(maxNum * maxNum);
    }
}
