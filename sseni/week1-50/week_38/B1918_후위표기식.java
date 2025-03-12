package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1918_후위표기식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);

            if(token == '(') {  // 들어오는 괄호일 때,
                stack.push(token);
            } else if(token == '*' || token == '/') {  // 곱셈, 나눗셈 연산자일 때,
                while(!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    sb.append(stack.pop());
                }
                stack.push(token);
            } else if(token == '+' || token == '-'){ // 덧셈, 뺄셈 연산자일 때,
                while(!stack.empty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.push(token);
            } else if(token == ')'){ // 닫는 괄호일 때,
                char top = stack.pop();
                while(!stack.empty() && top != '('){
                    sb.append(top);
                    top = stack.pop();
                }
            } else sb.append(token); // 값일 때,

            System.out.println(stack);
        }

        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
