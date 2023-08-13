package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1046 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val1 = sc.nextInt();
        int val2 = sc.nextInt();
        int val3 = sc.nextInt();
        System.out.printf("%d\n%.1f\n", val1 + val2 + val3, (float) (val1 + val2 + val3)/3);
    }
}
