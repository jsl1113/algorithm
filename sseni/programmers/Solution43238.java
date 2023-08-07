package com.example.javaproject3.psstudy;

import java.util.*;

public class Solution43238 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 1; // 최선의 경우
        long right = (long) times[times.length - 1] * n;  // 최악의 경우

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for(int t : times)
                sum += mid / t;  // 심사관마다 중간 시간을 기준으로 심사할 수 있는 사람 수의 합

            if (sum < n) // 심사하는 사람 수가 적을 때 시간을 늘림
                left = mid + 1;
            else {  // 심사하는 사람의 수가 더 많거나 같을 때 시간을 줄임
                right = mid - 1;
                answer = mid; // mid 는 right 가 줄어들 경우에 최솟값이므로 answer에 저장
            }
        }
        return answer;
    }


}
