package com.example.javaproject3.psstudy;

import java.util.Arrays;
import java.util.Stack;

public class Solution42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < answer.length; i++) { // 하나의 주식 가격 기준으로 비교
            for (int j = i + 1; j < answer.length; j++) {  // i 의 다음 가격부터 비교하여
                answer[i]++;
                if (prices[i] > prices[j]) // 가격이 떨어지면
                    break; // 비교 종료 후 다음 주식을 기준으로 다시 비교
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution42584().solution(new int[]{1, 2, 3, 2, 3})));
    }
}
