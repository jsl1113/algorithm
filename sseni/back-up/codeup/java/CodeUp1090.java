package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1090 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.nextInt() * (long) Math.pow(sc.nextInt(), sc.nextInt() - 1));
    }
}
