package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1124 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String c = str.substring(str.lastIndexOf("C") + 1, str.lastIndexOf("H"));
        String h = str.substring(str.lastIndexOf("H") + 1);
        System.out.println(12 * Integer.parseInt(c) + Integer.parseInt(h));
    }
}
