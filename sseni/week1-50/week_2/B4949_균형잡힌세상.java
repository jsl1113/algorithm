package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            Stack<String> stack = new Stack<>();
            String str = br.readLine();
            if (str.equals(".")) break;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '(' || c == '[') stack.push(str.substring(i, i + 1));
                else if (c == ')' || c == ']') {
                    if (
                            stack.isEmpty() ||
                            (stack.peek().equals("(") && c == ']') ||
                            (stack.peek().equals("[") && c == ')')
                    ) {
                        stack.push(str.substring(i, i + 1));
                        break;
                    }
                    stack.pop();
                }
            }
            sb.append(!stack.isEmpty() ? "no" : "yes");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
