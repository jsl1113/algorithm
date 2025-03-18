package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이 문제 ... 굉장히 귀찮다 .......
public class B14500_테트로미노 {
    static int n, m, arr[][], answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func();
        System.out.println(answer);
    }

    static void func() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                answer = Math.max(answer, arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 3; j++) {
                answer = Math.max(answer, arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i][j + 3]);
            }
        }

        for (int i = 0; i < n - 3; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 3][j]);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                answer = Math.max(answer, arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 1][j + 2]);
                answer = Math.max(answer, arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 2]);
                answer = Math.max(answer, arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j] + arr[i + 1][j + 1]);
                answer = Math.max(answer, arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1]);
                answer = Math.max(answer, arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 1][j + 2] + arr[i][j + 1]);

                // 대칭
                answer = Math.max(answer, arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j]);
                answer = Math.max(answer, arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 1][j + 2] + arr[i][j + 2]);
                answer = Math.max(answer, arr[i][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 1][j + 2]);
            }
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                answer = Math.max(answer, arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 2][j + 1] + arr[i + 2][j]);
                answer = Math.max(answer, arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 2][j]);
                answer = Math.max(answer, arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j + 1]);
                answer = Math.max(answer, arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j]);
                answer = Math.max(answer, arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j + 1]);

                // 대칭
                answer = Math.max(answer, arr[i][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 2][j + 1]);
                answer = Math.max(answer, arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 2][j + 1]);
                answer = Math.max(answer, arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j]);
            }
        }
    }
}
