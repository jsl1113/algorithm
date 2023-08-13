package com.example.javaproject3.pg;

import java.util.Arrays;

public class Solution181922 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];

            // s 와 e 사이의 i 에 대해, i 가 k 의 배수면 arr[i] 에 ++1
            for (int j = s; j <= e; j++) {
                if(j % k == 0) arr[j]++;
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution181922 solution181922 = new Solution181922();
        solution181922.solution(new int[]{0, 1, 2, 4, 3}, new int[][]{{0, 4, 1}, {0, 3, 2}, {0, 3, 3}});
    }
}
