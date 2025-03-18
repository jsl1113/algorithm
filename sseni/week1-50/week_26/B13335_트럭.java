package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13335_트럭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int time = 0, weight = 0;
        Queue<int[]> queue = new LinkedList<>(); // int[]{ 무게, 시간 }

        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && weight + arr[i] > L) {
                int[] truck = queue.poll();
                weight -= truck[0];
                time = Math.max(time, truck[1] + w - 1);
            }

            queue.add(new int[]{arr[i], ++time});
            weight += arr[i];
        }

        while (!queue.isEmpty()) {
            int[] truck = queue.poll();
            time = truck[1] + w;
        }

        System.out.println(time);
    }
}
