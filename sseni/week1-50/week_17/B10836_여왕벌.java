package com.example.algorithm.study.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 평범 구현 문제 느낌
public class B10836_여왕벌 {
    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(arr[i], 1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            for (int j = m - 1; j >= 0; j--) {
                if(zero != 0) zero--;
                else if(one != 0){
                    arr[j][0] += 1;
                    one--;
                } else if(two != 0){
                    arr[j][0] += 2;
                    two--;
                }
            }

            for (int j = 1; j < m; j++) {
                if(zero != 0) zero--;
                else if(one != 0){
                    arr[0][j] += 1;
                    one--;
                } else if(two != 0){
                    arr[0][j] += 2;
                    two--;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < m; j++) {
                arr[i][j] = Math.max(Math.max(arr[i - 1][j], arr[i - 1][j - 1]), arr[i][j - 1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
