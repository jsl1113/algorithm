package com.example.javaproject3.psstudy;

import java.util.Arrays;

public class Solution42747 {
    public int solution(int[] citations) {
        // n 편 중, h 번 이상 인용된 논문이 h 편 이상
        int answer = 0;
        Arrays.sort(citations);  // citations 정렬
        for (int i = 0; i < citations.length - 1; i++) {
            int h = citations.length - i;  // 최대로 될 수 있는 h 부터 시작
            if (citations[i] >= h) {  // h 보다 해당 인덱스 값이 크다면
                answer = h;
                break;
            }
        }
        return answer;
    }
}
