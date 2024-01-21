package com.example.algorithm.study.week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2792_보석상자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int start = 1, end = Arrays.stream(arr).max().getAsInt();
        while (start < end) {
            int mid = (start + end) / 2;

            int cnt = 0;
            for (int num : arr) {
                if (num % mid == 0) cnt += (num / mid);
                else cnt += (num / mid) + 1;
            }

            if (cnt > n) start = mid + 1;
            else end = mid;
        }
        System.out.println(end);
    }
}
