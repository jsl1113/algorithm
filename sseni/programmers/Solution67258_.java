package com.example.javaproject3.psstudy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution67258_ {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();  // <보석, 보석의 개수>
        int kind = new HashSet<>(Arrays.asList(gems)).size(); // 보석 종류의 개수
        int length = Integer.MAX_VALUE, start = 0;

        if(kind == 1) return new int[]{1, 1};

        for (int end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

            // start 번째 보석이 중복이면, 보석의 개수를 줄이고 시작 구간을 1 증가
            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }

            // map 에 모든 보석 종류가 존재하는 경우 && 최소 구간일 경우
            if (map.size() == kind && length > (end - start)) {
                length = end - start;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
        }

        return answer;
    }
}
