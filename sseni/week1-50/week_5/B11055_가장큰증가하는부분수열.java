package com.example.algorithm.study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 처음에 실패했던 이유는 그냥 dp 전 꺼랑만 비교해서
// 맨 뒤부터 클 때마다 갱신하고 했었는데 그 더 이전의 값이 더 클 수도 있다는 걸 간과했다.
// dp[i] = 처음부터 차례대로 계산하여 해당하는 수가 들어갈 때의 가장 큰 부분 수열
// arr = [1, 100, 2, 50, 60, 3, 5, 6, 7, 8] 이면
// dp[3] = 1 ~ 50 까지 50이 들어갈 때 가장 큰 값의 부분수열 합
public class B11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strArray = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < strArray.length; i++) {
            arr[i] = Integer.parseInt(strArray[i]);
        }

        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = arr[i];

            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + arr[i]);
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
