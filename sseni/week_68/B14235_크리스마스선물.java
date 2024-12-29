package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// a 가 0 이면, 선물 줘야함
// a 가 0 이 아니면, 선물 충전
public class B14235_크리스마스선물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            if (a == 0) {
                if(pq.isEmpty()) sb.append(-1).append("\n");
                else sb.append(pq.poll()).append("\n");
            } else {
                for (int j = 0; j < a; j++) {
                    pq.offer(Integer.parseInt(st.nextToken()));
                }
            }
         }

        System.out.println(sb);
    }
}
