package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num != 0) pq.offer(num);
            else if(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);
    }
}
