package com.example.algorithm.study.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수들의 합이랑 자료형 ? 뺴고는 비슷해서 금방 풀었다.
public class B1806_부분합 {
    static long n, s, answer = Integer.MAX_VALUE;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void solution() {
        int start = 0, end = 0;
        long sum = arr[0];
        while (end < n) {
            if (sum >= s) {
                answer = Math.min(answer, end - start + 1);
                sum -= arr[start++];
            } else {
                if (end == n - 1) break;
                sum += arr[++end];
            }
        }

        System.out.println(answer != Integer.MAX_VALUE ? answer : 0);
    }


    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        s = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new long[(int) n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
    }
}
