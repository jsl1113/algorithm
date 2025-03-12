package com.example.algorithm.study.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15810_풍선공장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long start = 0, end = (long) arr[0] * m;
        while (start <= end) {
            long mid = (start + end) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (mid / arr[i]);
            }

            if (sum < m) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(start);
    }
}
