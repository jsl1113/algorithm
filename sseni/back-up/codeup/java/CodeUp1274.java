package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1274 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int factor = 0; // 약수의 개수를 셈
        for (int i = 2; i * i <= num; i++) {
            if(num % i == 0) factor++;
        }
        System.out.println(factor == 0 ? "prime" : "not prime");
    }
}
