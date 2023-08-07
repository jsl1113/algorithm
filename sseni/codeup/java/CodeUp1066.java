package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<3;i++){
            System.out.println(sc.nextInt() % 2 == 0 ? "even" : "odd");
        }
    }
}
