package com.example.algorithm.study.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11497_통나무건너뛰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int[] result = new int[n];
            int start = 0, end = n - 1;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) result[end--] = arr[i];
                else result[start++] = arr[i];
            }

            int max = Math.abs(result[n - 1] - result[0]);
            for (int i = 0; i < n - 1; i++) {
                max = Math.max(max, Math.abs(result[i] - result[i + 1]));
            }

            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
