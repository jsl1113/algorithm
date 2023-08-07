package com.example.javaproject3.psstudy;

public class Solution12926 {
    public String solution(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {  // s 길이만큼 반복
            if (s.substring(i, i + 1).equals(" ")) answer += " ";  // 한 글자를 잘라 공백이면 변환 없이 answer 에 추가
            else {  // 알파벳이면
                char c = s.charAt(i);  // 한 글자를 char 타입으로 변환

                // a~z : 97~122, A~Z : 65~90
                if ((Character.isUpperCase(c) && c + n > 90) ||  // c + n 한 값이 대문자이면서 'Z' 보다 크거나
                        (Character.isLowerCase(c) && c + n > 122))  // c + n 한 값이 소문자이면서 'z' 보다 크면
                    answer += (char) (c + n - 26);  // 26 을 빼서 char 형으로 answer 에 저장
                else answer += (char) (s.charAt(i) + n); // c + n 한 값이 a~z 또는 A~Z 범주 안에 있을 때 n을 더해 char 형으로 answer 에 저장
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution12926 solution12926 = new Solution12926();
        solution12926.solution("z Y abX", 4);

    }
}
