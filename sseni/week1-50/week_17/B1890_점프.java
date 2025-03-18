package com.example.algorithm.study.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 처음엔 그냥 단순히 +1 해줬었는데 생각해보니까
// 만약 dp[a][b] 까지 가능한 경로가 2라면,
// 다음 a,b 에서 이동하는 지점 x,y의  dp[x][y] 도 +2 가 되어야 한다를 깨달음
public class B1890_점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) continue;
                if (i + arr[i][j] < n) dp[i + arr[i][j]][j] += dp[i][j];
                if (j + arr[i][j] < n) dp[i][j + arr[i][j]] += dp[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}
