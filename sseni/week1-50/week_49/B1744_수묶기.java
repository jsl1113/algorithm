package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B1744_수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plusPQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minusPQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp <= 0) minusPQ.add(tmp);
            else plusPQ.add(tmp);
        }

        int answer = 0;
        while (!minusPQ.isEmpty()) {
            int num = minusPQ.poll();

            if (minusPQ.isEmpty()) {
                answer += num;
                break;
            }

            if(minusPQ.peek() == 0) minusPQ.poll();
            else answer += num * minusPQ.poll();
        }

        while (!plusPQ.isEmpty()) {
            int num = plusPQ.poll();

            if (plusPQ.isEmpty()) {
                answer += num;
                break;
            }

            if(plusPQ.peek() == 1) answer += num + plusPQ.poll();
            else answer += num * plusPQ.poll();
        }

        System.out.println(answer);
    }
}
