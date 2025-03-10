package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1475_방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[10];
        while (n > 0) {
            int d = n % 10;
            arr[d]++;
            n /= 10;
        }

        int cnt = (arr[6] + arr[9] + 1) / 2;
        int answer = cnt;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) continue;
            answer = Math.max(answer, arr[i]);
        }

        System.out.println(answer);
    }
}
