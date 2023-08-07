package com.example.javaproject3.psstudy;

public class Solution60057 {
    public int solution(String s) {
        int answer = s.length();
        // ex. "abcabcdede"
        for (int i = 1; i < s.length() / 2 + 1; i++) {  // i = 패턴 길이를 정할 index
            String pattern = s.substring(0, i);  // 패턴 길이
            int cnt = 1;  // 패턴이 몇 번 반복되는지 카운트
            String tmp = "";  // 압축한 문자열 저장할 변수 tmp
            for (int j = i; j <= s.length(); j += i) {  // 패턴 길이부터 시작해 문자열 길이까지 반복, 패턴 길이만큼씩 증가
                if (pattern.equals(s.substring(j, Math.min(j + i, s.length())))) cnt++; // 자른 문자열이 패턴과 같다면 카운트
                    // (자를 때 문자열 총 길이보다 커지면 OutofIndex error 나서 Math.min 추가)
                else {  // 자른 문자열과 패턴이 다르다면
                    tmp += cnt > 1 ? cnt + pattern : pattern;  // cnt 가 1보다 크면 cnt+pattern 저장, 작으면 pattern 저장
                    pattern = s.substring(j, Math.min(j + i, s.length()));  // 자른 문자열을 새로운 패턴으로 설정
                    cnt = 1; // 패턴 반복 횟수 초기화
                }
            }
            answer = Math.min(answer, tmp.length() + pattern.length());  // 마지막 패턴 길이를 더한 압축 문자열 길이와 answer 중 작은 값으로 저장
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution60057 solution60057 = new Solution60057();
        System.out.println(solution60057.solution("abcabcdede"));
    }
}
