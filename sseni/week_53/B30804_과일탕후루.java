package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B30804_과일탕후루 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        int answer = 0, start = 0;
        for (int end = 0; end < n; end++) {
            hm.put(arr[end], hm.getOrDefault(arr[end], 0) + 1);

            // 종류가 두 개 이상이면, 왼쪽 꺼 제거해나가면서 개수 줄이기
            while (hm.size() > 2) {
                hm.put(arr[start], hm.get(arr[start]) - 1);
                if(hm.get(arr[start]) == 0){
                    hm.remove(arr[start]);
                }
                start++;
            }

            answer = Math.max(answer, end - start + 1);
        }

        System.out.println(answer);
    }
}
