package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int start = 0, end = n - 1;

            while (true) {
                if(start == i) start++;
                else if(end == i) end--;

                if(start >= end) break; // 종료 조건을 또 적어줘야 함

                int mid = arr[start] + arr[end];

                if(mid > arr[i]) end--;
                else if(mid < arr[i]) start++;
                else {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
