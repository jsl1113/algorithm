package com.example.algorithm.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10872_팩토리얼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(factorial(n, 1));
    }

    private static long factorial(int n, long sum) {
        if(n <= 1) return sum;
        return factorial(n - 1, sum * n);
    }
}
