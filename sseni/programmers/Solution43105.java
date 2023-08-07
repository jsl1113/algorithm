package com.example.javaproject3.psstudy;

import java.util.Arrays;

public class Solution43105 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];  // 초깃값

        for (int i = 1; i < triangle.length; i++) {  // 꼭대기부터 바닥까지의 경로로 숫자 합 계산 반복
            dp[i][0] = dp[i-1][0] + triangle[i][0];  // 맨 왼쪽 값은 한 줄 위의 가장 왼쪽 값과 현재 값을 더한 값

            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]; // 한 줄 위의 오른쪽 값과 왼쪽 값 중 큰 값에 현재 값을 더해 저장
                answer = Math.max(answer, dp[i][j]);  // 더 큰 값으로 갱신
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution43105().solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}
