package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1109 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int age = sc.nextInt();
        char code = sc.next().charAt(0);
        float key = sc.nextFloat();
        System.out.println(name);
        System.out.println(age);
        System.out.println(code);
        System.out.println(key);
    }
}
