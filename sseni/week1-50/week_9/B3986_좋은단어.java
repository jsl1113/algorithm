package com.example.algorithm.study.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 만약 선끼리 교차하지 않으면서, 각 글자를 정확히 한 개의 다른 위치에 있는 같은 글자와 짝 지을 수 있다
// = 좋은 단어
// 처음에 좋은 단어의 의미를 이해하지 못해서 문제에 있는 예제들을 계속 보고
// 스택 문제라는 걸로 거의 유추했다보면 된다 ;;
// 스택에 넣어가면서, peek() 한 문자와 이제 넣을 문자가 같으면 pop, 아니면 push
// 스택이 비어있으면? 좋은 단어
// Tip : replaceAll 로 하면 50% 에서 시간초과가 난다.
public class B3986_좋은단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            // 두 개씩 짝을 짓기 때문에 홀수이면 절대 좋은 단어가 아님.
            if (str.length() % 2 == 1) continue;

            Stack<Character> stack = new Stack<>();
            stack.push(str.charAt(0));
            for (int j = 1; j < str.length(); j++) {
                if (stack.size() > 0 && stack.peek() == str.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(str.charAt(j));
                }
            }

            if (stack.isEmpty()) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
