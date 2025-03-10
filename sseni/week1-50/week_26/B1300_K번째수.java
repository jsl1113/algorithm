package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1300_K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long start = 1;
        long end = k;

        while(start < end) {
            long mid = (start + end) / 2;
            long cnt = 0;

            for(int i = 1; i <= n; i++){
                cnt += Math.min(mid / i, n);
            }

            if(k <= cnt){
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}
