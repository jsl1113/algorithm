package com.example.algorithm.study.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 투포인터
// 처음에 틀린 건, 포인터 증가 조건을 잘못 설정함
public class B22945_팀빌딩 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = n - 1, answer = 0;
        while (start <= end) {
            answer = Math.max((end - start - 1) * Math.min(arr[start], arr[end]), answer);

            // 최대치를 구하는거니까, 더 큰 값을 남기고 작은 값 쪽의 포인터를 증가시킴
            if(arr[start] < arr[end]) start++;
            else end--;
        }

        System.out.println(answer);
    }
}
