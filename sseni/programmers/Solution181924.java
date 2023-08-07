package com.example.javaproject3.pg;

import java.util.Arrays;

public class Solution181924 {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            int i = query[0];
            int j = query[1];
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution181924 solution181924 = new Solution181924();
        solution181924.solution(new int[]{0,1,2,3,4}, new int[][]{{0,3},{1,2},{1,4}});
    }
}
