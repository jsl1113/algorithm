package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RV_B116663_선분위의점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            result[i] = binarySearch(a, b, n, arr);
        }

        for (int i = 0; i < m; i++) {
            System.out.println(result[i]);
        }
    }

    public static int binarySearch(int a, int b, int n, int[] arr) {
        int startIdx, endIdx, start = 0, end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > b) end = mid - 1;
            else start = mid + 1;
        }
        endIdx = end;

        start = 0; end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < a) start = mid + 1;
            else end = mid - 1;
        }
        startIdx = start;

        return endIdx - startIdx + 1;
    }
}
