package com.example.javaproject3.psstudy;

public class Solution81301 {
    public int solution(String s) {
        String[] num = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};  // 각 숫자에 대응하는 영단어
        for(int i=0; i<num.length; i++) //  영단어 배열만큼 반복
            s = s.replace(num[i], Integer.toString(i)); // 해당하는 영단어가 문자열에 있다면 원래 숫자로 대체
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        Solution81301 solution81301 = new Solution81301();
        System.out.println(solution81301.solution("2three45sixseven"));
    }
}
