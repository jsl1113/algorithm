package com.example.algorithm.study.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1535_안녕 {
    static int n;
    static int[] dp, health, pleasure;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    static int solution() {
        dp = new int[101];

        for (int i = 0; i < n; i++) {
            for (int j = 100; j > health[i]; j--) {  // 해당 사람을 넣었을 때의 dp 값 갱신
                dp[j] = Math.max(dp[j], pleasure[i] + dp[j - health[i]]);
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[100];
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        health = new int[n];
        pleasure = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) health[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) pleasure[i] = Integer.parseInt(st.nextToken());
    }
}
