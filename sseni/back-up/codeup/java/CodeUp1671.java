package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1671 {
    public static void play(int user, int computer) {
        // 0바위 1가위 2보
//        int flag = user - computer;
//        switch (flag) {
//            case 0: return "tie";
//            case -1: return "win";
//            case 1, 2: return "lose";
//            default: return "Error";
//        }
        if (computer == user) {
            System.out.println("tie");
        } else if ((computer == 0 && user == 1) || (computer == 1 && user == 2) || (computer == 2 && user == 0)) {
            System.out.println("lose");
        } else {
            System.out.println("win");
        }
    }
    public static void main(String[] args) {
        CodeUp1671 rpc = new CodeUp1671();
        Scanner sc = new Scanner(System.in);
        play(sc.nextInt(), sc.nextInt());
    }
}
