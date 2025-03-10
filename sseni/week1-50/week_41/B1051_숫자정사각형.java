package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1051_숫자정사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int min = Math.min(n, m);
        while (true) {
            for (int i = 0; i <= n - min; i++) {
                for (int j = 0; j <= m - min; j++) {
                    int num = arr[i][j];

                    if(num == arr[i][j+(min-1)] &&
                    num == arr[i+(min-1)][j] &&
                    num == arr[i+(min-1)][j+(min-1)]) {
                        System.out.println(min * min);
                        return;
                    }
                }
            }

            min--;
        }
    }
}
