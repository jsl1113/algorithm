package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aNum = sc.nextInt();
        int bNum = sc.nextInt();
        int cNum = sc.nextInt();
        if(aNum % 2 == 0) System.out.println(aNum);
        if(bNum % 2 == 0) System.out.println(bNum);
        if(cNum % 2 == 0) System.out.println(cNum);
    }
}
