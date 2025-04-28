package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 연속하는 가장 긴 수열(LIS)을 찾으면, 나머지 수를 옮기는 게 최솟값
public class B2631_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];

            if(list.isEmpty() || num > list.get(list.size() - 1)) {
                list.add(num);
            } else { // 이진탐색 수행해서 LIS 값 찾기
                int start = 0, end = list.size() - 1;
                while (start < end) {
                    int mid = start + (end - start) / 2;

                    if(list.get(mid) < num) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }

                list.set(end, num);
            }
        }

        System.out.println(n - list.size());
    }
}
