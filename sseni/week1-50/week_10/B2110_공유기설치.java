package com.example.algorithm.study.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최대 거리를 이분탐색하는데, 최대 거리를 넘을 때마다 공유기를 하나씩 세움
// 그리고 공유기 개수가 안 넘치면? 최대 거리 저장
// 개수가 넘치면? mid 조정
public class B2110_공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        System.out.println(binarySearch(1, arr[arr.length - 1] - arr[0], n, c, arr));
    }

    public static int binarySearch(int start, int end, int n, int c, int[] arr) {
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 1;  // 공유기 개수
            int num = arr[0];  // 최근에 설치한 공유기 번호
            for (int i = 1; i < n; i++) {
                if(arr[i] - num < mid) continue;

                cnt++;
                num = arr[i];
            }

            if (cnt < c) {
                end = mid - 1;
            } else {
                answer = mid;
                start = mid + 1;
            }
        }

        return answer;
    }
}
