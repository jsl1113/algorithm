package com.example.javaproject3.pg;

import java.lang.reflect.Array;
import java.util.*;

public class Solution138477 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> arr = new ArrayList<>();
        int idx = 0;
        for(int i=0; i<score.length; i++){
            if(i < k) arr.add(score[i]);
            else {
                Collections.sort(arr);
                int min = arr.get(0);
                if(score[i] > min)  {
                    arr.add(score[i]);
                    arr.remove(0);
                }
            }
            Collections.sort(arr);
            answer[idx++] = arr.get(0);
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution138477 solution138477 = new Solution138477();
        solution138477.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200});
    }
}
