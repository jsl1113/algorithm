package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1078 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i=2; i<=n; i+=2){
            if (i % 2 == 0) sum += i;
        }
        System.out.println(sum);
    }
}
