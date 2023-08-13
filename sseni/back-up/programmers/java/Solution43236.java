package com.example.javaproject3.psstudy;

import java.util.Arrays;

public class Solution43236 {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);  // 정렬
        long left = 1, right = distance;
        int answer=0;

        while (left <= right) {
            long mid = (left + right) / 2; // 기준
            int remove = 0, before = 0;  // remove: 제거하는 돌 개수, before: 이전 돌 위치 값

            for (int rock : rocks) {
                if ((rock - before) < mid) remove++; // (현재 돌-이전 돌) 이 최소 거리 기준치인 mid 보다 작으면 제거
                else before = rock;  // 돌이 제거되지 않을 때 이전의 돌 위치 변경해줌
            }
            if((distance - before) < mid) remove++;  // 마지막 돌이 before에 저장되어 있기 때문에 마지막 돌도 제거할 돌인지 확인

            if (remove > n)  right = mid - 1;  // 제거한 돌 개수가 n보다 크면 mid 는 최소 거리 기준이 아닌 것, 범위를 줄여야 함
            else { // n보다 작으면, 일단 최소 거리는 될 수 있음
                answer = Math.max(answer, (int) mid);  //  answer와 mid 중 최댓값을 answer에 저장
                left = mid + 1; // 최소 거리를 늘려줌
            }
        }

        return answer;
    }
}