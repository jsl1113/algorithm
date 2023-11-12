package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RV_B21758_꿀따기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" "))
                .map(Long::parseLong)
                .mapToLong(Long::longValue)
                .toArray();

        long answer = 0;

        // 벌벌통
        long sum = Arrays.stream(arr).sum();
        long x = sum - arr[0];  // 벌 하나는 맨 끝에 있어야 최댓값이다.
        long y = x;
        for (int i = 1; i < n - 1; i++) { // 두 번째 벌 위치 => arr[i]
            y -= arr[i];
            answer = Math.max(answer, (x - arr[i]) + y);
        }

        // 통벌벌
        x = sum - arr[n - 1];
        y = x;
        for (int i = n - 2; i > 0; i--) {
            y -= arr[i];
            answer = Math.max(answer, (x - arr[i]) + y);
        }

        // 벌통벌
        x = 0;
        y = sum - arr[n - 1];  // 두 벌이 양 끝에 있어야 최댓값이다.
        for (int i = 1; i < n - 1; i++) {  // 통 위치 => arr[i]
            x += arr[i];
            y -= arr[i - 1];
            answer = Math.max(answer, x + y);
        }

        System.out.println(answer);
    }
}
