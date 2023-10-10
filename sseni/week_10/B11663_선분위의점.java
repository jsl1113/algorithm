package com.example.algorithm.study.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 뭐가 자꾸 한 끗씩 안 맞아서 조금 시간이 걸렸다.
public class B11663_선분위의점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] point = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .toArray();

        Arrays.sort(point);

        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int start = 0, end = n - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (point[mid] > b) end = mid - 1;
                else start = mid + 1;
            }
            int endIdx = end;

            start = 0;
            end = n - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (point[mid] < a) start = mid + 1;
                else end = mid - 1;
            }
            int startIdx = start;

            result[i] = endIdx - startIdx + 1;
        }

        for (int i = 0; i < m; i++){
            System.out.println(result[i]);
        }
    }
}
