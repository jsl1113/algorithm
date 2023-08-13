package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[23];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[num - 1]++;
        }
        for (int i = 0; i < 23; i++) System.out.printf("%d ", arr[i]);
    }
}
