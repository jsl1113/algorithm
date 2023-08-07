package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.next().split("\\.");
        System.out.printf("%s-%s-%s", arr[2], arr[1], arr[0]);
    }
}
