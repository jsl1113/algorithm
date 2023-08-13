package com.example.javaproject3.psstudy;

import java.util.Arrays;

public class Solution12917 {
    public String solution(String s) {
        if(s.length() == 1) return s;
        char[] arr = s.toCharArray();  // 문자열을 char 배열로
        Arrays.sort(arr);  // 정렬
        return new StringBuilder(new String(arr)).reverse().toString();  // 정렬된 arr를 StringBuilder 객체로 생성하여 역순으로 뒤집어 리턴
    }
}
