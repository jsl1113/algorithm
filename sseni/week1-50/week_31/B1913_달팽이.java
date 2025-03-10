package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 칸수 늘려가면서, 위 -> 오 -> 아래 -> 왼
public class B1913_달팽이 {
    static int n, d, arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        int x = n / 2;
        int y = n / 2;

        solution(x, y);
    }

    static void solution(int x, int y) {
        StringBuilder sb = new StringBuilder();
        int[] answer = new int[2];

        int cnt = 1, num = 1;
        while (true) {
            for (int i = 0; i < cnt; i++) { // 위 - x 줄어듦
                arr[x--][y] = num++;
            }

            if (num == n * n + 1) break;

            for (int i = 0; i < cnt; i++) { // 오 - y 늘어남
                arr[x][y++] = num++;
            }

            cnt++;

            for (int i = 0; i < cnt; i++) { // 아래 - x 늘어남
                arr[x++][y] = num++;
            }

            for (int i = 0; i < cnt; i++) { // 왼 - y 줄어듦
                arr[x][y--] = num++;
            }

            cnt++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");

                if (arr[i][j] == d) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
            sb.append("\n");
        }

        sb.append(answer[0] + 1).append(" ").append(answer[1] + 1);
        System.out.println(sb);
    }
}
