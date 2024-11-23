package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1027_고층건물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            double left = -1_000_000_000;
            double right = -1_000_000_000;

            int l = 0;
            int r = 0;
            for (int j = i - 1; j >= 0; j--) {
                double tmp = (double) (arr[j] - arr[i]) / (i - j);
                if (tmp > left) {
                    left = tmp;
                    l++;
                }
            }

            for (int j = i + 1; j < n; j++) {
                double tmp = (double) (arr[j] - arr[i]) / (j - i);
                if (tmp > right) {
                    right = tmp;
                    r++;
                }
            }

            if ((l + r) > answer) answer = l + r;

        }

        System.out.println(answer);
    }
}
