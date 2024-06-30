package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16401_과자나눠주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long start = 1, end = Arrays.stream(arr).max().getAsLong();
        while (start <= end) {
            long mid = (start + end) / 2;

            int sum = 0;
            for (int i = 0; i < n; i++) { // 과자를 mid 만큼 나눠준다
                sum += arr[i] / mid; // mid 보다 arr[i]가 작으면 해당 과자를 안주는 것
            }

            // mid 만큼씩 나눠준 사람이 m보다 많으면, 과자를 늘려도 됨
            if (sum >= m) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(end);
    }
}
