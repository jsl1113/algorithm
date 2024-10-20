package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17266_어두운굴다리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = n;
        while (start < end) {
            int mid = (start + end) / 2;

            int tmp = 0;
            for (int i = 0; i < m; i++) {
                int s = arr[i] - mid;
                int e = arr[i] + mid;

                if(tmp < s) break;
                else tmp = e;
            }

            if(n <= tmp) end = mid;
            else start = mid + 1;
        }

        System.out.println(start);
    }
}
