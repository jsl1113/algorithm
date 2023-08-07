package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aNum = sc.nextInt();
        int bNum = sc.nextInt();
        int cNum = sc.nextInt();
        System.out.println(aNum > bNum ? (bNum > cNum ? cNum : bNum) : (aNum > cNum ? cNum : aNum));
    }
}
