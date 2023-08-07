package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1067 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(num < 0 ? "minus" : "plus");
        System.out.println(num % 2 == 0 ? "even" : "odd");
    }
}
