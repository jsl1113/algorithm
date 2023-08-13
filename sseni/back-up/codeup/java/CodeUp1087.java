package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1087 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long sum = 1;
        for(int i=2; i<=num; i++){
            if(num <= sum) break;
            else sum += i;
        }
        System.out.println(sum);
    }
}
