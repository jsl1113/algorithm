package com.example.algorithm.study.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 두 칸을 바꿀 수 있는 모든 경우의 수를 계산, 한 경우의 수마다 최댓값 계산
// <- 맞는 건가? 시간초과? 안나나
//  한 경우의 수가 끝나고는? 다시 원상복구
//  <- 애초에 arr 를 clone 해서 스왑하는 걸 생각했던 거 같다. 원상복구하는 건 생각 못하고
// 이건 얕은 복사라 원본이 바뀐다. (그럼 clone 의 용도는 뭐지 ?)
public class B3085_사탕게임 {
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        search(n, arr);
        if (max == n) {
            System.out.println(max);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(i, i, j, j + 1, arr);
                search(n, arr);
                swap(i, i, j, j + 1, arr);
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(j, j+1, i, i, arr);
                max = Math.max(search(n, arr), max);
                swap(j, j+1, i, i, arr);
            }
        }

        System.out.println(max);
    }

    public static void swap(int x1, int x2, int y1, int y2, char[][] arr) {
        char tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }

    public static int search(int n, char[][] arr) {
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }

                max = Math.max(max, cnt);
            }
        }

        return max;
    }
}
