package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1092 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        int p3 = sc.nextInt();
        int day = 1;
        while (true) {
            if (day % p1 == 0 && day % p2 == 0 && day % p3 == 0)
                break;
            else day++;
        }
        System.out.println(day);
    }
}
