package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 현재 나가는 차량이 그 이후에 나가는 차량보다 나중에 들어왔으면 카운트
public class B2002_추월 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hm.put(br.readLine(), i);
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = hm.get(br.readLine());
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
