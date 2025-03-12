package com.example.algorithm.study.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1 3 6 6 7 9, diff = 0 1 2 2 3
// 3 6 7 8 10 12 14 15 18 20, diff = 1 1 1 2 2 2 2 3 3
// 저번에 유사한 문제 풀었던 기억이 나서 쉽게 풀었다.
// 한 번 틀렸는데, 조건을 확인해보니 N(1 ≤ N ≤ 10,000), K(1 ≤ K ≤ 1000)
// k 가 n 보다 더 크거나 같을 경우, 최솟값은 무조건 0 이기 때문을 간과했달까
public class B2212_센서 {
    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    static int solution() {
        if (n <= k) return 0;

        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(diff);

        for (int i = n - 2; i >= n - k; i--) {
            diff[i] = 0;
        }
        return Arrays.stream(diff).sum();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }
}
