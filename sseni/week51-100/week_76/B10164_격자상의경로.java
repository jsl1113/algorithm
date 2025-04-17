package com.example.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B10164_격자상의경로 {
    static int n, m, k;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];

        arr[0][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        System.out.println(func());
    }

    static int func() {
        if (k == 0) return arr[n][m];

        int a = k / m + (k % m > 0 ? 1 : 0);
        int b = k - (a - 1) * m;
        int c = n - a + 1;
        int d = m - b + 1;

        return arr[a][b] * arr[c][d];
    }
}
