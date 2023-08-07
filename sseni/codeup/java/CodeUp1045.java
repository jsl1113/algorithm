package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1045 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aNum = sc.nextInt();
        int bNum = sc.nextInt();
        System.out.printf("%d\n%d\n%d\n%d\n%d\n%.02f\n", aNum + bNum, aNum - bNum, aNum * bNum, aNum / bNum, aNum % bNum, (float) aNum / bNum);
    }
}
