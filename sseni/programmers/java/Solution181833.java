package com.example.javaproject3.pg;

public class Solution181833 {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (i == j) answer[i][j] = 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution181833 s = new Solution181833();
        s.solution(6);
    }
}
