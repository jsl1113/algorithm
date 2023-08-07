package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp4596 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[10][10];
        int x, y;

        int maxValue = 0;
        x = 1;
        y = 1;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int now = sc.nextInt();
                if (maxValue < now) {
                    maxValue = now;
                    x = i + 1;
                    y = j + 1;
                }
            }
        }
        System.out.println(maxValue + "\n" + x + " " + y);
    }
}
