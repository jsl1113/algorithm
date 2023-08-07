package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1278 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        while(n != 0){
            n /= 10;
            cnt++;
        }
        System.out.println(cnt);

        int num = sc.nextInt();
        System.out.println(String.valueOf(num).length());
        System.out.println((int) (Math.log10(num) + 1));
    }
}
