package com.example.algorithm.study.week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// n이 1이면, 안 섞어도 된다.
public class B1715_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        if(n == 1) {
            System.out.println(0);
            return;
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            if(pq.size() == 1) break;
            int sum = pq.poll() + pq.poll();
            pq.add(sum);
            answer += sum;
        }

        System.out.println(answer);
    }
}
