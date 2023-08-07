package com.example.javaproject3.psstudy;

import java.util.Arrays;

public class Solution12949 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        // ex. 3x2 * 2x4 = 3x4 결과라는 것
        for(int k=0; k<arr1.length; k++){
            for(int i=0; i<arr2[0].length; i++){
                for(int j=0; j<arr2.length; j++){
                    answer[k][i] += (arr1[k][j] * arr2[j][i]);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        int[][] arr3 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr4 = {{3, 3}, {3, 3}};
        Solution12949 solution12949 = new Solution12949();
        solution12949.solution(arr1, arr2);
        solution12949.solution(arr3, arr4);
    }
}
