package com.example.algorithm.study.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 예전에 스택 문제 풀었을 때 int형 변수로 +, - 하던 기억이 있어서 생각났다.
// 닫는 괄호를 만났을 때 쇠막대기 조각을 판단할 수 있지 않을까 부터 생각의 발단
// 스택으로 풀었다면 스택 사이즈로 구분했겠지
public class B10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int answer = 0, stick = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stick++;
            } else {
                stick--;

                char next = input.charAt(i - 1);
                if (next == '(') {
                    answer += stick;
                } else {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
