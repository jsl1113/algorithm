package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c = sc.next().toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.println("\'" + c[i] + "\'");
        }
    }
}
