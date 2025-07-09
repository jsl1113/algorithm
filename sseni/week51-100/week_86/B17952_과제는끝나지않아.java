package com.company;

import java.io.*;
import java.util.*;

public class B17952_과제는끝나지않아 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<int[]> stack = new Stack<>();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if ("1".equals(st.nextToken())) {
                stack.push(new int[]{
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                });
            }

            if (!stack.isEmpty() && --stack.peek()[1] == 0) {
                answer += stack.pop()[0];
            }
        }

        System.out.println(answer);
    }
}