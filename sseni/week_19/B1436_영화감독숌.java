package com.example.algorithm.study.week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1436_영화감독숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 666;
        while (n != 0) {
            if (String.valueOf(answer).contains("666")) n--;
            answer++;
        }

        System.out.println(answer - 1);
    }
}
