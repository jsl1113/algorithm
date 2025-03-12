package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B7795_먹을것인가먹힐것인가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] A = new int[n];
            int[] B = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            sb.append(binarySearch(A, B, n, m)).append("\n");
        }

        System.out.println(sb);
    }

    static int binarySearch(int[] A, int[] B, int n, int m) {
        int answer = 0, start, end, mid;

        for (int i = 0; i < n; i++) {
            start = 0;
            end = m - 1;

            while (start <= end) {
                mid = (start + end) / 2;

                if (B[mid] < A[i]) start = mid + 1;
                else end = mid - 1;
            }

            answer += start;
        }

        return answer;
    }
}
