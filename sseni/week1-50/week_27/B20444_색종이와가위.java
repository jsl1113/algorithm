package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20444_색종이와가위 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long start = 0, end = n / 2;

        while (start <= end) {
            long x = (start + end) / 2;
            long y = n - x;
            long mid = (x + 1) * (y + 1);

            if (mid == k) {
                System.out.println("YES");
                return;
            } else if (mid > k) {
                end = x - 1;
            } else {
                start = x + 1;
            }
        }
        System.out.println("NO");
    }
}
