package com.example.algorithm.study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int i = 1;
        while (queue.size() != 1){
            if (i % 2 == 1) {
                queue.remove();
            } else {
                int num = queue.poll();
                queue.add(num);
            }
            i++;
        }

        System.out.println(queue.poll());
    }
}
