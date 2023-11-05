package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 각 원생들의 차이를 저장하고 정렬한 후, k-1개 만큼 빼고 더한다.
// 가 생각이 났다.
public class RV_B13164_행복유치원 {
    static int n, k;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            list.add(arr[i] - arr[i - 1]);
        }

        Collections.sort(list);

        int answer = 0;
        for (int i = 0; i < n - k; i++) {
            answer += list.get(i);
        }
        System.out.println(answer);
    }
}
