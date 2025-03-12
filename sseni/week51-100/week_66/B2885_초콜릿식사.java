package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2885_초콜릿식사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        int size = 1;
        int cnt = 0;
        int answer = 0;

        while (size < k) {
            size *= 2;
            answer = size;
        }

        while (k > 0) {
            if (k >= size) k -= size;
            else {
                size /= 2;
                cnt++;
            }
        }

        System.out.println(answer + " " + cnt);
    }
}
