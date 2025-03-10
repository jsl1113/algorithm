package com.example.algorithm.study.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2003_수들의합 {
    static int n, m, answer = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        init();

        int start = 0, end = 0, sum = arr[0];
        while (end < n){
            if(sum >= m) {  // m보다 크거나 같으면, 앞쪽 인덱스를 증가시켜 sum 크기를 줄인다.
                if(sum == m) answer++;
                sum -= arr[start++];
            } else { // m보다 작으면, 뒤쪽 인덱스를 증가시켜 sum 크기를 늘린다.
                if(end == n - 1) break;
                else sum += arr[++end];
            }
        }

        System.out.println(answer);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
