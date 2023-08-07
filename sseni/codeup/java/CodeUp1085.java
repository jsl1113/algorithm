package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long b = sc.nextLong();
        long h = sc.nextLong();
        long c = sc.nextLong();
        long s = sc.nextLong();
        long bit = (long) (h * b * c * s);
        float result  = bit / 1024.0f / 1024.0f / 8.0f;
        System.out.printf("%.1f MB\n", result);
    }
}
