package com.example.javaproject3.psstudy;

import java.util.Stack;

public class Solution76502 {
    public int solution(String s) {
        int cnt = 0;  // 괄호 문자열 카운팅
        for (int i = 0; i < s.length(); i++) { // 회전하는 턴마다
            Stack<Character> stack = new Stack<>(); // 새로운 스택 생성
            cnt += isRightBracket(stack, s) == true ? 1 : 0; // 올바른 괄호인지 판단하는 메소드를 호출하여 맞다면 카운트
            s = s.substring(1, s.length()) + s.charAt(0); // 문자열 회전
        }
        return cnt;
    }

    // 올바른 괄호인지 판단하는 메소드
    public boolean isRightBracket(Stack<Character> stack, String s) {
        for (int i = 0; i < s.length(); i++) { // 문자열 길이 마다
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') stack.push(c); // 여는 괄호일 때, 스택에 push
            else { // 닫는 괄호일 때,
                if (stack.empty()) return false; // 스택이 비어있을 시 false

                char top = stack.pop();  // 스택 상단의 값 pop
                // top 이 탐색 중인 닫는 괄호에 해당하는 여는 괄호가 아니라면
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{'))
                    return false;
            }
        }
        return stack.empty(); // 스택이 비어있으면, 올바른 괄호 문자열이므로 true
    }

    public static void main(String[] args) {
        System.out.println(new Solution76502().solution("[)(]"));
    }
}
