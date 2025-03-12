package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11728_배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        String[] arrA = br.readLine().split(" ");
        String[] arrB = br.readLine().split(" ");

        int[] arr = new int[a + b];
        int idx = 0;

        for (int i = 0; i < a; i++) {
            arr[idx++] = Integer.parseInt(arrA[i]);
        }

        for (int i = 0; i < b; i++) {
            arr[idx++] = Integer.parseInt(arrB[i]);
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a + b; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}
