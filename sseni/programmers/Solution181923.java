package com.example.javaproject3.pg;

import java.util.Arrays;

public class Solution181923 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];

            //s와 e 사이 수 중, k 보다 크면서 가장 작은 arr[i] 찾기
            int min = Integer.MAX_VALUE;
            for (int j = s; j <= e; j++) {
                if(k < arr[j]) min = Math.min(arr[j], min);
            }
            if(min < Integer.MAX_VALUE) answer[i] = min;
            else answer[i] = -1;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        Solution181923 solution181923 = new Solution181923();
        solution181923.solution(new int[]{0, 1, 2, 4, 3}, new int[][]{{0, 4, 2}, {0, 3, 2}, {0, 2, 2}});

    }
}
