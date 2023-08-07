package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int b = sc.nextInt();
        System.out.printf("%.2f MB\n", (double) w * h * b / 8388608);
    }
}
