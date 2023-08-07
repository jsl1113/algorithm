package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1083 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0) System.out.printf("X ", i);
            else System.out.printf("%d ", i);
        }
    }
}
