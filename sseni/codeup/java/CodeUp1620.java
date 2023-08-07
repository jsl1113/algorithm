package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1620 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n >= 10){
            n = func(n);
        }
        System.out.println(n);
    }

    public static int func(int n){
        int sum = 0;
        while(n != 0){
            sum += n %10;
            n /= 10;
        }
        return sum;
    }
}
