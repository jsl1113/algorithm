package com.example.algorithm.study.week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// LIS(최장 증가 부분수열), LDS(최장 감소 부분수열)
// 가장 긴 증가하는 수열과 가장 긴 감소하는 수열이 합쳐진 문제
public class B11054_가장긴바이토닉부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dpL = new int[n];
        int[] dpR = new int[n];
        for (int i = 0; i < n; i++) {
            dpL[i] = 1;
            dpR[i] = 1;
        }

        // 왼 -> 오
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) dpL[i] = Math.max(dpL[j] + 1, dpL[i]);
            }
        }

        // 오 -> 왼
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j]) dpR[i] = Math.max(dpR[j] + 1, dpR[i]);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dpL[i] + dpR[i] - 1);
        }
        System.out.println(answer);
    }
}
