package com.example.javaproject3.psstudy;

public class Solution84512_ {
    static final int[] RATE_OF_INCREASE = {781, 156, 31, 6, 1};

    public int solution(String word) {
        int answer = word.length();

        for (int i = 0; i < word.length(); i++) {
            answer += (RATE_OF_INCREASE[i] * "AEIOU".indexOf(word.charAt(i)));
        }
        return answer;
    }
}
