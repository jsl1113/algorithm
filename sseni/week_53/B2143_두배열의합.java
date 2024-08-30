package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 모든 부분합을 계산하면서, 그 합이 T - 부분합(A)인 경우의 수를 카운트
public class B2143_두배열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Long, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long sum = 0;

            for (int j = i; j < n; j++) {
                sum += A[j];
                hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            }
        }

        long cnt = 0;
        for (int i = 0; i < m; i++) {
            long sum = 0;

            for (int j = i; j < m; j++) {
                sum += B[j];
                cnt += hm.getOrDefault(T - sum, 0);
            }
        }

        System.out.println(cnt);
    }
}
