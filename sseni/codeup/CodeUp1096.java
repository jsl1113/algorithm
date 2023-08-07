package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1096 {
    public static void main(String[] args) {
        int[][] arr = new int[20][20];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[sc.nextInt()][sc.nextInt()] = 1;
        }
        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }
}
