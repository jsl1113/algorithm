package com.example.javaproject3.psstudy;

public class Solution12918 {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() != 4 && s.length() != 6) return false;  // 문자열의 길이가 4,6이 아니라면 false 반환
        try {
            int num = Integer.parseInt(s);  // 문자열을 Integer 로 치환, 알파벳이 포함되어 있을 경우 예외 발생
            return true;  // 숫자로 변환되었다면 true 반환
        } catch (Exception e) {
            return false;  // 문자열에 알파벳이 포함되어 있다는 의미, false 반환
        }
    }

    public static void main(String[] args) {
        Solution12918 solution12918 = new Solution12918();
        System.out.println(solution12918.solution("1234"));
    }
}
