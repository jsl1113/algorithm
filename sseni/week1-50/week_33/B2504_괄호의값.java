package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
a * ( b + c ) = a * b + a * c
( ) [ [ ] ] -> 2 + 3 x 3 = 11
*/
// 스택으로 푸는 괄호 문제는 항상 헷갈린다 ㅜ
public class B2504_괄호의값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0, value = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(' || c == '[') {
                stack.push(c);
                value *= (c == '(') ? 2 : 3;
            } else {
                if (!stack.isEmpty() && isPair(stack.peek(), c)) { // 쌍이 맞는 괄호
                    if ((c == ')' && str.charAt(i - 1) == '(') || (c == ']' && str.charAt(i - 1) == '[')) { // 바로 직전의 괄호와 쌍이 맞으면,
                        answer += value;
                    }

                    stack.pop();  // 계산한 괄호 pop
                    value /= (c == ')') ? 2 : 3;
                } else {
                    answer = 0;
                    break;
                }
            }
        }

        System.out.println(!stack.isEmpty() ? 0 : answer);
    }

    static boolean isPair(char c1, char c2) {
        if (c1 == '(' && c2 == ')') return true;
        if (c1 == '[' && c2 == ']') return true;

        return false;
    }
}
