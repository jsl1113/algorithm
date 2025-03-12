package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int tower = arr[i];

            while (!stack.isEmpty()) {
                if (stack.peek()[0] > tower) {
                    sb.append(stack.peek()[1]).append(" ");
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            }

            stack.push(new int[]{tower, i});
        }

        System.out.println(sb);
    }
}
