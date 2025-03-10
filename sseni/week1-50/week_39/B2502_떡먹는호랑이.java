package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2502_떡먹는호랑이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[d + 1];
        arr[d] = k;

        int a = 1;
        while (true) {
            arr[1] = a;

            for (int i = a; i <= k; i++) {
                arr[2] = i;

                for (int j = 3; j < d; j++) {
                    arr[j] = arr[j - 1] + arr[j - 2];
                }

                if (arr[d] == arr[d - 1] + arr[d - 2]) {
                    System.out.println(arr[1]);
                    System.out.println(arr[2]);
                    return;
                }
            }

            a++;
        }
    }
}
