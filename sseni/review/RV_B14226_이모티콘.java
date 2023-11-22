package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RV_B14226_이모티콘 {
    static int s, answer = Integer.MAX_VALUE;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, 1, 0);
        System.out.println(answer);
    }

    static void dfs(int cnt, int emotion, int clipboard) {
        if(cnt >= answer) return;
        if(dp[clipboard][emotion] <= cnt) return;
        dp[clipboard][emotion] = cnt;

        if(emotion == s){
            answer = Math.min(answer, cnt);
            return;
        } else if(emotion > s) {
            answer = Math.min(answer, cnt + emotion - s);
            return;
        }

        // 복사해 클립보드에 저장
        dfs(cnt + 2, 2 * emotion, emotion);
        // 붙여넣기
        if(clipboard != 0) dfs(cnt + 1, emotion + clipboard, clipboard);
        // 삭제하기
        if(emotion > 1) dfs(cnt + 1, emotion - 1, clipboard);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());
        dp = new int[s + 1][s * 2 + 1];
        for (int i = 0; i <= s; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
    }
}
