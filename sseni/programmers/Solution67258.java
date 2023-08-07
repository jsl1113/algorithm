package com.example.javaproject3.psstudy;

import java.util.*;

public class Solution67258 {
    public int[] solution(String[] gems) {
        HashSet hs = new HashSet<>(Arrays.asList(gems)); // 보석 종류
        HashMap<String, Integer> map = new HashMap<>(); // 보석 종류별 개수
        Queue<String> q = new LinkedList<>();

        int len = Integer.MAX_VALUE, start = 0, idx = 0;

        if (hs.size() == 1) return new int[]{1, 1};  // 종류가 하나면 1, 1 리턴

        for (String gem : gems) {
            map.put(gem, map.getOrDefault(gem, 0) + 1); // 구간에 늘리며 보석 추가
            q.add(gem);

            // 이전에 큐에 넣은 보석과 중복일 때
            // 앞에 보석을 제거하고 map 에도 적용
            while (map.get(q.peek()) > 1) { // 구간 첫 번째 보석(q.peek)이 2개 이상인 경우에만 반복
                map.put(q.peek(), map.get(q.poll()) - 1); // 구간 첫 번째 보석 제거
                idx++; // 다음 지점으로 변경
            }

            // 구간에 등록된 보석 종류의 수와 전체 보석 종류 수가 같고,
            // 이전에 해당 조건을 충족한 구간 길이보다 짧은 경우
            if (map.size() == hs.size() && len > q.size()) {
                len = q.size();  // 해당 조건 길이로 갱신
                start = idx; // 현재 지점으로
            }
        }
        return new int[]{start + 1, start + len};
    }

    public static void main(String[] args) {
        int[] result = new Solution67258().solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        System.out.println(Arrays.toString(result));
    }
}
