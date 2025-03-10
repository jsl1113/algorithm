package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// j 를 k 부터 w 까지 내려가면, w 는 j 보다 무조건 작을 때만 동작
// 따로 if(j - arr[i].w > 0) 조건을 적을 필요 없음
public class B12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bag[] arr = new bag[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new bag(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] dp = new int[k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = k; j >= arr[i].w; j--) {
                dp[j] = Math.max(dp[j], arr[i].v + dp[j - arr[i].w]);
            }
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(dp[k]);
    }

    static class bag {
        int w, v;

        bag(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
