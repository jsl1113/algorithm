package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RV_B2138_전구와스위치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split("");
        String[] s2 = br.readLine().split("");

        int[] arr = new int[n];
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
            answer[i] = Integer.parseInt(s2[i]);
        }

        int[] arr2 = Arrays.copyOf(arr, n);
        arr2[0] = swap(arr2[0]);
        arr2[1] = swap(arr2[1]);

        int[] result = new int[2];
        result[0] = solution(arr, answer, n);
        result[1] = solution(arr2, answer, n);
        if(result[1] != -1) result[1]++;

        if(result[0] == -1) System.out.println(result[1]);
        else if(result[1] == -1) System.out.println(result[0]);
        else System.out.println(Math.min(result[0], result[1]));
    }

    private static int solution(int[] arr, int[] answer, int n) {
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] != answer[i - 1]) {
                cnt++;
                arr[i - 1] = swap(arr[i - 1]);
                arr[i] = swap(arr[i]);
                if (i != n - 1) arr[i + 1] = swap(arr[i + 1]);
            }
        }

        return arr[n - 1] == answer[n - 1] ? cnt : -1;
    }

    private static int swap(int n) {
        return n == 0 ? 1 : 0;
    }
}
