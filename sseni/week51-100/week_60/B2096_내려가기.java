package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2096_내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] maxDp = new int[3];
        int[] minDp = new int[3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (i == 0) {
                maxDp[0] = minDp[0] = a;
                maxDp[1] = minDp[1] = b;
                maxDp[2] = minDp[2] = c;
            } else {
                int x = maxDp[0], y = maxDp[2];
                maxDp[0] = Math.max(maxDp[0], maxDp[1]) + a;
                maxDp[2] = Math.max(maxDp[1], maxDp[2]) + c;
                maxDp[1] = Math.max(Math.max(x, maxDp[1]), y) + b;

                int z = minDp[0], w = minDp[2];
                minDp[0] = Math.min(minDp[0], minDp[1]) + a;
                minDp[2] = Math.min(minDp[1], minDp[2]) + c;
                minDp[1] = Math.min(Math.min(z, minDp[1]), w) + b;
            }

        }

        System.out.println(Arrays.stream(maxDp).max().getAsInt() + " "
                + Arrays.stream(minDp).min().getAsInt());
    }
}
