package com.example.javaproject3.psstudy;

public class Solution12916 {
    boolean solution(String s) {
        int pCnt = 0, yCnt = 0;  // p, y 카운트 변수
        s = s.toLowerCase();  // s 문자열 모두 소문자로 변환
        for(int i=0; i<s.length();i++){  // 문자열 길이만큼 반복하여 "p"일 때, "y"일 때 검사
            if(s.substring(i, i+1).equals("p")) pCnt++;
            else if(s.substring(i, i+1).equals("y")) yCnt++;
        }
        return pCnt == yCnt ? true : false;  // p의 개수와 y의 개수가 같으면 true, 아니면 false 반환
    }

    public static void main(String[] args) {
        Solution12916 solution12916 = new Solution12916();
        System.out.println(solution12916.solution("pPoooyYy"));
    }
}
