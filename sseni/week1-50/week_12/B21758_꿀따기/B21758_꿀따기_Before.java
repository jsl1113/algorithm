package com.example.algorithm.study.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 55점 맞은 문제, 4번 서브태스크를 통과하지 못함
// 누적합을 사용하지 않고, 이중 for 문을 사용해서 틀렸다
public class B21758_꿀따기_Before {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long answer = 0;

        // 1) 벌 벌 통
        long sum = Arrays.stream(arr).sum();
        for (int i = 1; i < n; i++) {
            long num1 = sum - arr[0] - arr[i];
            long num2 = sum;
            for (int j = 0; j <= i; j++) {
                num2 -= arr[j];
            }
            answer = Math.max(answer, num1 + num2);
        }

        // 2) 통 벌 벌
        for (int i = n - 2; i >= 0; i--) {
            long num1 = sum - arr[n - 1] - arr[i];
            long num2 = sum;
            for (int j = n - 1; j >= i; j--) {
                num2 -= arr[j];
            }
            answer = Math.max(answer, num1 + num2);
        }

        // 3) 벌 통 벌
        for (int i = 1; i < n - 1; i++) {
            long num1 = 0;
            for (int j = 1; j <= i; j++) {
                num1 += arr[j];
            }
            long num2 = 0;
            for (int j = n - 2; j >= i; j--) {
                num2 += arr[j];
            }
            answer = Math.max(answer, num1 + num2);
        }

        System.out.println(answer);
    }
}
