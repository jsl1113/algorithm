package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1071 {
    public static void main(String[] args) {
        loop();
    }

    public static void loop(){
        Scanner sc = new Scanner(System.in);
//        while(true){
//            int n = sc.nextInt();
//            if(n == 0) break;
//            else System.out.println(n);
//        }
        int n;
        do {
            n = sc.nextInt();
            if(n != 0) System.out.println(n);
        } while(n != 0);
    }
}
