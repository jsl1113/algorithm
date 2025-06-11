package com.company;

import java.io.*;
import java.util.*;

public class B1080_행렬 {
    static int n, m;
    static boolean[][] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        A = new boolean[n][m];
        B = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                A[i][j] = str.charAt(j) == '1';
            }
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                B[i][j] = str.charAt(j) == '1';
            }
        }

        if (n < 3 || m < 3) {
            if(isSame()) System.out.println(0);
            else System.out.println(-1);
            System.exit(0);
        }

        int answer = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if(A[i][j] != B[i][j]) {
                    reverse(i, j);
                    answer++;
                }
            }
        }

        if(isSame()) System.out.println(answer);
        else System.out.println(-1);
    }

    static void reverse(int x, int y) {
        for (int i = x; i < x+3; i++) {
            for (int j = y; j < y + 3; j++) {
                A[i][j] = !A[i][j];
            }
        }
    }

    static boolean isSame() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] != B[i][j]) return false;
            }
        }
        return true;
    }
}
