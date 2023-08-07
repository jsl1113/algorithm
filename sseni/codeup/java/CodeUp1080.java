package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1080 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxNum = sc.nextInt();
        int sum = 0;
        int i = 1;
        for (i = 1; i < maxNum; i++) {
            if(sum >= maxNum) break;
            else sum += i;
        }
        System.out.println(i-1);
    }
}
