package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B4889_안정적인문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 1;
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if(s.contains("-")) break;

            char[] arr = s.toCharArray();

            int cnt = 0;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];

                if(c == '{') stack.add(c);
                else {
                    if(stack.isEmpty()){
                        cnt++;
                        stack.add('{');
                    } else stack.pop();
                }

            }

            if(!stack.isEmpty()) {
                cnt += stack.size() / 2;
            }

            sb.append(num++).append(". ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
