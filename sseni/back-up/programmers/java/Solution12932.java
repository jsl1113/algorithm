package com.example.javaproject3.psstudy;

import java.util.*;

public class Solution12932 {
    public int[] solution(long n) {
        String s = String.valueOf(n);  // n을 String 으로 변환
        int[] answer = new int[s.length()];  // n의 자릿수만큼 answer 배열 크기 지정
        int idx = 0;  // answer 에 거꾸로 저장하기 위한 추가 index 변수 선언

        // 역순으로 저장하기 위한 for 문
        for (int i = s.length()-1; i >= 0; i--) {
            answer[idx++] = Integer.parseInt(s.substring(i, i+1)); // substring 으로 한 글자씩 잘라 int 형으로 변환 후 answer 에 저장
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution12932 s = new Solution12932();
        s.solution(123456789);
    }
}
