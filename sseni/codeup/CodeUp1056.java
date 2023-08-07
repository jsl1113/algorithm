package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1056 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.nextInt() != sc.nextInt() ? 1 : 0);

        // XOR
        int val1 = sc.nextInt();
        int val2 = sc.nextInt();
        boolean result = val1 != val2;
        System.out.printf("%d\n", result ? 1 : 0);
    }
}
