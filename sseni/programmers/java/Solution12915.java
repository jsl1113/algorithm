package com.example.javaproject3.psstudy;

import java.util.Arrays;

public class Solution12915 {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        for (int i = 0; i < strings.length; i++)  // n 번째 문자와 원본 문자열을 더한 문자열을 answer에 저장
            answer[i] = strings[i].charAt(n) + strings[i];

        Arrays.sort(answer);  // 정렬

        for (int i = 0; i < strings.length; i++)
            answer[i] = answer[i].substring(1);  // 맨 앞 문자 제외한 원본 문자열을 다시 answer에 저장

        return answer;
    }
}
