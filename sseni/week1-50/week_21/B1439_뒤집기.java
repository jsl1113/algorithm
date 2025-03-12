package com.example.algorithm.study.week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 0 기준일 때, 1 기준일 때, 몇 번 바뀌어야 하는지 카운트
public class B1439_뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int zero = 0, one = 0;
        if (arr[0] == '1') zero++;
        else one++;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                if (arr[i] == '1') zero++;
                else one++;
            }
        }

//        System.out.println(zero + " " + one);
        System.out.println(Math.min(zero, one));
    }
}
