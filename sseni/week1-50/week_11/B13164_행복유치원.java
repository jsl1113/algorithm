package com.example.algorithm.study.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 처음에는, 각 조마다 두 명씩 꼭 들어가야 하는 줄 알고 잘못 짰다
// 몇 명이 들어가든 상관없고 k 개의 조면 된다.
// k = 1 이면, 10 - 1  = 9 가 출력, 근데? (3-1) + (5-3) + (6-5) + (10-6) = 9 도 같은 원리
// 각 원생마다의 차이가 들어있는 배열에서,
// k = 2 라면, 가장 큰 값을 하나 뺌 ( 큰 값을 뺀다는 의미: 그 구간에서 짤라서 조로 만든다 )
public class B13164_행복유치원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            list.add(arr[i + 1] - arr[i]);
        }
        Collections.sort(list);
        Collections.reverse(list);

        int sum = 0;
        for (int i = k - 1; i < n - 1; i++) {
            sum += list.get(i);
        }

        System.out.println(sum);
    }
}
