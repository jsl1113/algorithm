package com.example.javaproject3.psstudy;

import java.util.Arrays;

public class Solution12930 {
    public String solution(String s) {
        String answer = "";
        String[] strArray = s.split("");  // "  abc  bc d" -> [ ,  , a, b, c,  ,  , b, c,  , d]

        int cnt = 0;  // 단어 개수 카운트할 변수 -> 위 예시에서 0, 0, 1, 2, 3, 0, 0, 1, 2, 0, 1 순으로 변화
        for(String str : strArray){
            if(str.equals(" ")) {  // 해당하는 값이 공백이라면
                cnt = 0;  // 단어 개수 카운트 변수 0으로 초기화
                answer += str;  // answer 에 공백 저장
            }
            // 공백이 아닌 알파벳이라면,
            // 먼저 단어 카운트해주고, 단어 개수가 짝수면 소문자, 홀수면 대문자로 변환하여 answer 에 저장
            else answer += ++cnt%2 == 0 ? str.toLowerCase() : str.toUpperCase();
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution12930 solution12930 = new Solution12930();
        System.out.println(solution12930.solution("  abc  bc d"));
    }
}
