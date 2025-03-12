package com.example.algorithm.study.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 음수면, 증가
// 양수면, 감소
public class B2470_두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];

        int left = 0, right = n - 1;
        while (left < right) {
            int sum = Math.abs(arr[left] + arr[right]);
            if (sum < min) {
                answer[0] = arr[left];
                answer[1] = arr[right];
                min = sum;
            }
            if (arr[left] + arr[right] < 0) left++;
            else right--;
        }

//        System.out.println(min);
        System.out.println(answer[0] + " " + answer[1]);
    }
}
