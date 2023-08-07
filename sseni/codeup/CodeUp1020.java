package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1020 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
//        String[] me = sn.next().split("-");
//        System.out.println(me[0] + me[1]);

        String str = sn.next();
        System.out.println(str.substring(0, 6) + str.substring(7));
    }
}
