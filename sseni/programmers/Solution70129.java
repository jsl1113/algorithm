package com.example.javaproject3.psstudy;

import java.util.Arrays;

public class Solution70129 {
    public int[] solution(String s) {
        int cnt = 0, zero = 0;  // 변환 횟수, 제거한 0 개수
        while(!s.equals("1")){  // s 가 "1"이 될 때까지
            cnt += 1;
            zero += s.length() - s.replace("0", "").length();  // s의 전체 길이 - 0을 제거한 s 길이 (제거한 0의 개수 카운트)
            s = s.replace("0", "");  //  s를 0을 제거한 s로 변환
            s = Integer.toBinaryString(s.length());  //  s의 길이를 이진 변환
        }
        return new int[]{cnt, zero};
    }

    public static void main(String[] args) {
        Solution70129 solution70129 = new Solution70129();
        int[] arr = solution70129.solution("01110");
        System.out.println(Arrays.toString(arr));
    }
}
