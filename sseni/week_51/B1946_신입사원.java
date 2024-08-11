package com.example.algorithm.study.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1946_신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            int cnt = 1;

            int[] arr = new int[m + 1];
            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a] = b;
            }

            int tmp = arr[1];
            for (int j = 2; j <= m; j++) {
                if (arr[j] < tmp) {
                    tmp = arr[j];
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}
