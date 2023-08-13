package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1070 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        if(month == 1 || month == 2 || month == 12) System.out.println("winter");
        else if(month == 3 || month == 4 || month == 5) System.out.println("spring");
        else if(month == 6 || month == 7 || month == 8) System.out.println("summer");
        else System.out.println("fall");
    }
}
