package com.example.algorithm.study.week6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] d = new int[n+1];
        d[1] = arr[1];
        if(n > 1){
            d[2] = arr[1] + arr[2];
        }

        for(int i = 3; i <= n; i++){
            // dp[i-1]: i번째 잔을 선택하지 않는 경우
            // dp[i-2] + 현재 잔의 양: i번째 잔을 선택하고, 이전 잔을 선택하지 않는 경우
            // dp[i-3] + 이전 잔과 현재 잔의 양: i번째 잔을 선택하고, 이전 잔도 선택하는 경우
            d[i] = Math.max(d[i-1], Math.max(d[i-2], d[i-3] + arr[i-1]) + arr[i]);
        }

        System.out.println(d[n]);
    }
}
