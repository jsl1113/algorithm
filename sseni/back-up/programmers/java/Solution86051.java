package com.example.javaproject3.psstudy;

import java.util.HashSet;

public class Solution86051 {
    public int solution(int[] numbers) {
        HashSet<Integer> hs = new HashSet<>();
        for (int num : numbers) hs.add(num); // numbers 배열을 hashset에 저장
        int answer = 0;
        for (int i = 0; i <= 9; i++) { // 0~9 중, hashset에 포함되어 있지 않으면 answer에 누적 합
            if (!hs.contains(i)) answer += i;
        }
        return answer;
    }

    public int solution_(int[] numbers) {
        int sum = 45;
        for (int num : numbers)
            sum -= num;
        return sum;
    }
}
