package com.example.algorithm.study.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1 2 3 3 4
// 진짜 과장 약간 보태어 1분 컷
public class B11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i] * (n - i);
        }
        System.out.println(sum);
    }
}
