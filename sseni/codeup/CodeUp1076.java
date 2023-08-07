package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char cVal = sc.next().charAt(0);
        char c = 'a';
        while (c != cVal) {
            System.out.print(c++ + " ");
        }
        System.out.print(cVal);
    }
}
