package com.example.javaproject3.psstudy;

import java.util.Arrays;
import java.util.HashSet;

public class Solution68644 {
    public int[] solution(int[] numbers) {
        HashSet<Integer> hs = new HashSet<>();  //  중복 방지 위해 hashset
        for (int i = 0; i < numbers.length; i++) {  // 두 수를 더하기 위한 이중 for 문
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) hs.add(numbers[i] + numbers[j]); // index가 같지 않을 때, hashset 에 배열의 i번째와 j번째 값을 더해 넣어줌
            }
        }
        Integer[] tmp = hs.toArray(hs.toArray(new Integer[0]));  // hashset 을 Integer 배열로 변환
        Arrays.sort(tmp); // sort
        return Arrays.stream(tmp).mapToInt(Integer::intValue).toArray(); // Integer 배열을 int 배열로 변환
    }

    public static void main(String[] args) {
        Solution68644 solution68644 = new Solution68644();
        System.out.println(Arrays.toString(solution68644.solution(new int[]{5, 0, 2, 7})));
    }
}
