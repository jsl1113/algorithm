package com.example.javaproject3.codeup;

import java.util.Arrays;
import java.util.Scanner;

public class CodeUp1098 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[h + 1][w + 1];
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int d = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

//            for (int j = 1; j <= l; j++) {
//                if (d == 0) arr[x][y + j] = 1;
//                else arr[x + j][y] = 1;
//            }

            if (d == 0) {  // 가로로
                for (int j = y; j < y + l; j++) {
                    arr[x][j] = 1;
                }
            } else {  // 세로로
                for (int j = x; j < x + l; j++) {  //  2 3 j=1 (1,2)
                    arr[j][y] = 1;
                }
            }
        }

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }
}
