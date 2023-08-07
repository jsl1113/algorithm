package com.example.javaproject3.psstudy;

import java.util.*;

public class Solution84512 {
    static String[] arr = new String[]{"A", "E", "I", "O", "U"};  // 알파벳 모음 배열 전역 변수로 선언
    public void dic(List<String> list, String str, int len) {
        if (len > 5) return;  // 알파벳 모음이 5개이기 때문에, 길이가 5 이상이면 리턴
        list.add(str); // 매개변수로 받은 문자열을 리스트에 추가
        for (int i = 0; i < 5; i++) {  // 알파벳 모음 만큼 반복
            dic(list,str + arr[i], len + 1);  // 문자열에 알파벳 모음을 더한 문자열을 모음 사전 메소드의 매개변수로 다시 호출
        }
    }

    public int solution(String word) {
        List<String> list = new ArrayList<>(); // 영단어를 담을 리스트 선언
        dic(list,"", 0); // 모음 사전 메소드 호출, 실행이 끝나면 알파벳 배열 원소로만 이루어진 사전 리스트가 생성됨
        return list.indexOf(word); // 모음 사전 리스트에서 word 의 index 리턴 ( 사전 0 번째는 공백이기 때문에 +1 해서 리턴 안해도 됨 )
    }

    public static void main(String[] args) {
        Solution84512 solution84512 = new Solution84512();
        System.out.println(solution84512.solution("AAAAE"));
    }
}
