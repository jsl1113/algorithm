package com.example.algorithm.study.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 포인트는 이중 반복으로 짜지 않는 것
// 누적합의 포인트는 이전에 더해줬던 혹은 빼줬던 값을 활용하는 것
public class B21758_꿀따기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;

        // 1) 벌 벌 통
        long sum = Arrays.stream(arr).sum();
        long fix = sum - arr[0];  // 맨 왼쪽 벌 위치 고정
        long move = fix;
        for (int i = 1; i < n - 1; i++) {
            move -= arr[i]; // 현재 움직이는 벌 위치를 빼줬으니까 다음 턴에서 뺴줄 필요 없음
            answer = Math.max(answer, (fix - arr[i]) + move);
        }

        // 2) 통 벌 벌
        fix = sum - arr[n - 1];  // 맨 오른쪽 벌 위치 고정
        move = fix;
        for (int i = n - 2; i >= 0; i--) {
            move -= arr[i];
            answer = Math.max(answer, (fix - arr[i]) + move);
        }

        // 3) 벌 통 벌
        fix = 0; // 맨 왼쪽 벌 위치
        move = sum - arr[n - 1];   // 맨 오른쪽 벌 위치
        for (int i = 1; i < n - 1; i++) {
            fix += arr[i];  // 움직일 때마다 꿀통 위치를 더해주면 됨
            move -= arr[i - 1];  // 움직일 때마다 꿀통 전 위치를 뺴주면 됨
            answer = Math.max(answer, fix + move);
        }

        System.out.println(answer);
    }
}
