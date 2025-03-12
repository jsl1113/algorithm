package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1747_소수팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (true) {
            if (isPalindrome(n) && isPrime(n)) {
                System.out.println(n);
                return;
            }
            n++;
        }
    }

    static boolean isPalindrome(int n) {
        String str = Integer.toString(n);
        int len = str.length();

        for (int i = 0; i <= len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }

        return true;
    }

    static boolean isPrime(int n) {
        if(n == 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
