package com.example.algorithm.study;

import java.util.Arrays;
import java.util.Stack;

public class P154539_뒤에있는큰수찾기 {
    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = numbers.length - 1; i > -1; i--) {
            while (!stack.empty() && numbers[i] >= stack.peek()) {
                stack.pop();
            }

            answer[i] = !stack.empty() ? stack.peek() : answer[i];
            stack.push(numbers[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 3, 3, 5})));
        System.out.println(Arrays.toString(solution(new int[]{9, 1, 5, 3, 6, 2})));
    }
}
