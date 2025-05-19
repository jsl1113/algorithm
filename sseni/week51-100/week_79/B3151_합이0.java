package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3151_합이0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        int[] sum = new int[40_001];
        for(int i = 0; i < n; i++) {
            answer += sum[20_000 - arr[i]];

            for (int j = 0; j < i; j++) {
                sum[20_000 + arr[i] + arr[j]]++;
            }
        }

        System.out.println(answer);
    }
}
