package com.example.algorithm;

import java.io.*;

public class B1254_팰린드롬만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(i))) break;
            answer++;
        }

        System.out.println(answer);
    }

    private static boolean isPalindrome(String str) {
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}

