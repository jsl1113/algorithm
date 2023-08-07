package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1122 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minute = sc.nextInt();
        System.out.println(minute / 60 + " " + minute % 60);
    }
}
