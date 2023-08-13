package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1019 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String[] date = sn.next().split("\\.");
        int y = Integer.valueOf(date[0]);
        int m = Integer.valueOf(date[1]);
        int d = Integer.valueOf(date[2]);
        System.out.println(String.format("%04d.%02d.%02d", y, m, d));

    }
}
