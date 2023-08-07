package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1097 {
    public static void main(String[] args) {
        int[][] arr = new int[20][20];
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int j = 1; j <= 19; j++) {
                if (arr[x][j] == 0) arr[x][j] = 1;
                else arr[x][j] = 0;
            }

            for (int j = 1; j <= 19; j++) {
                if (arr[j][y] == 0) arr[j][y] = 1;
                else arr[j][y] = 0;
            }
        }
        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }
}
