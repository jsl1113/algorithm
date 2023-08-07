package com.example.javaproject3.psstudy;

public class Solution68935 {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        // String 으로 변환하면 자동으로 앞뒤 반전된 3진법 형식으로 저장됨
        // sb 변화 : 0 -> 00 -> 002 -> 0021
        while (n != 0) {
            sb.append(n % 3);  // StringBuilder 변수에 n%3 값을 추가
            n /= 3;  // n을 3 으로 나눔
        }

        int exp = 0;  // 3진법으로 변환하기 위한 지수 변수 초기화 0 -> 1 -> 2 -> 3
        for (int i = sb.length() - 1; i >= 0; i--) {  // 3진법 자릿수만큼 반복
            answer += Integer.parseInt(String.valueOf(sb.charAt(i))) * Math.pow(3, exp++);  // 한 글자를 가져와 Integer 형으로 변환 후 3진법 계산
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution68935 solution68935 = new Solution68935();
        solution68935.solution(45);
    }
}
