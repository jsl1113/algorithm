package com.example.javaproject3.psstudy;

public class Solution72410 {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();  // 1. 대문자를 소문자로 치환

        for (int i = 0; i < new_id.length(); i++) {  // 2. 문자열 길이만큼 반복하여 소문자, 숫자, 빼기, 밑줄, 마침표만 탐색
            char c = new_id.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.')  // 소문자, 숫자, 빼기, 밑줄, 마침표라면
                answer += c;  // answer에 추가
        }

        while (answer.indexOf("..") != -1)  // indexOf("..") : 문자열 안에서 ".." 를 찾지 못했을 경우, -1 반환됨
            answer = answer.replace("..", ".");  // 3. 연속된 부분의 마침표를 하나의 마침표로 치환

        if (!answer.equals("") && answer.charAt(0) == '.')  // 4. 문자열이 비어있지 않고, 마침표가 처음이나 끝에 있으면 제거
            answer = answer.substring(1);  // 맨 앞 자르기
        if (!answer.equals("") && answer.charAt(answer.length() - 1) == '.')
            answer = answer.substring(0, answer.length() - 1); // 맨 뒤 자르기

        if (answer.equals("")) answer += "a";  // 5. 빈 문자열이면 “a” 대입

        if (answer.length() >= 16) {  // 6. 16자 이상이면, 첫 15개 문자 제외 나머지 제거
            answer = answer.substring(0, 15); // 15 글자 이전까지 자르기
            if (answer.charAt(answer.length() - 1) == '.')  // 제거 후, 마침표가 끝에 위치하면 끝에 위치한 마침표 제거
                answer = answer.substring(0, answer.length() - 1);  // 맨 뒤 자르기
        }

        if (answer.length() <= 2) {  // 7. 길이가 2자 이하라면, 3자 이상이 될 때까지 마지막 문자를 끝에 붙임
            while (answer.length() < 3)  // 문자열 길이가 3이 될 때까지 반복하여 맨 끝 글자를 문자열에 더함
                answer += answer.charAt(answer.length() - 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution72410 solution72410 = new Solution72410();
        System.out.println(solution72410.solution("=.="));
    }
}
