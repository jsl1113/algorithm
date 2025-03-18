package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 각 자리수의 총 합이 3의 배수가 아니면 종료해야 한다.
public class B10610_30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        long n = s.length();
        int[] arr = new int[10];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(s.substring(i, i + 1));
            arr[tmp]++;
            sum += tmp;
        }

        if (!s.contains("0") || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (arr[i] > 0) {
                sb.append(i);
                arr[i]--;
            }
        }

        System.out.println(sb);
    }
}
