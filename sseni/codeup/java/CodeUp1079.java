package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1079 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c = 'q';
        while (true) {
            c = sc.next().charAt(0);
            if(c == 'q') break;
            else System.out.println(c);
        }
        System.out.println(c);
    }
}
