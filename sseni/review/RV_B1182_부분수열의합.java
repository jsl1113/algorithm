package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 1. 비트마스킹으로 부분 집합을 구한다.
// 2. 합과 s 를 비교하여 카운트한다.
public class RV_B1182 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        String[] strArray = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArray[i]);
        }

        int cnt = 0;
        for (int i = 1; i < (1 << n); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0){
                    list.add(arr[j]);
                }
            }

            int[] result = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                result[j] = list.get(j);
            }

            if(Arrays.stream(result).sum() == s) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
