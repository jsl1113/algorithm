package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RV_B2470_두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE, start = 0, end = n - 1;
        int v1 = arr[start], v2 = arr[end];
        while (start < end) {
            int sum = Math.abs(arr[start] + arr[end]);
            if(sum < min) {
                v1 = arr[start];
                v2 = arr[end];
                min = sum;
                if(sum == 0) break;
            }

            if(arr[start] + arr[end] > 0) end--;  // 0보다 크면 끝 쪽 포인터를 줄여야 함
            else start++; // 0보다 작으면 작은 쪽 포인터를 줄여야 함
        }
        System.out.println(v1 + " " + v2);
    }
}
