package com.example.javaproject3.psstudy;

public class Solution42898 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];  // y, x
        dp[0][0] = 1;

        for (int[] p : puddles)
            dp[p[1] - 1][p[0] - 1] = -1; // 물에 잠긴 지역은 -1로 표시

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dp[i][j] == -1) {  // 물에 잠긴 지역일 경우,
                    dp[i][j] = 0;
                     continue;
                }
                // 현재 위치까지 최단 경로의 개수는
                // 현재 위치의 왼쪽(x-1) + 위쪽(y-1) 값의 합과 같다.
                if (i != 0) dp[i][j] += dp[i - 1][j];  // y가 0이 아닐 때, 위쪽 값 add
                if (j != 0) dp[i][j] += dp[i][j - 1];  // x가 0이 아닐 때, 왼쪽 값 add
                dp[i][j] %= 1_000_000_007;
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution42898().solution(4, 3, new int[][]{{2,2}}));
    }
}
