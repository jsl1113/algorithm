package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1. 처음에 행과 열 각각 사탕 개수 최댓값 구하기
// 2. n이랑 같다면 그게 최대 개수
// 3. 아니면, 스왑해서 최대 개수를 갱신할 수 있는지 판단
// 거의 기억에 의존해서 푸는 느낌이었다 ㅠ
public class RV_B3085_사탕게임 {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        bruteForce(n, arr);
        if (result == n) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(i, i, j, j + 1, arr);
                bruteForce(n, arr);
                swap(i, i, j, j + 1, arr);
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(j, j + 1, i, i, arr);
                result = Math.max(bruteForce(n, arr), result);
                swap(j, j + 1, i, i, arr);
            }
        }

        System.out.println(result);
    }

    public static int bruteForce(int n, char[][] arr) {
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) cnt++;
                else cnt = 1;
                result = Math.max(result, cnt);
            }
        }

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) cnt++;
                else cnt = 1;
                result = Math.max(result, cnt);
            }
        }

        return result;
    }

    public static void swap(int a, int b, int c, int d, char[][] arr) {
        char tmp = arr[a][c];
        arr[a][c] = arr[b][d];
        arr[b][d] = tmp;
    }
}
