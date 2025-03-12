package com.example.algorithm.study.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 임티 1개 -> 3가지 연산 후 이모티콘 S개 만들기
// 1. 복사 -> 저장 -> 붙여넣기 : 기존 개수 x 2 (연산 2초 카운트)
// 3. 임티 중 하나 삭제 : 기존 개수 -1
// 처음에 dfs 으로만 짰더니 시간초과났다. dp 써서 이미 이전의 경우 체크하기
public class B14226_이모티콘 {
    static int s, answer = Integer.MAX_VALUE;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());
        dp = new int[s + 1][s * 2 + 1];
        for (int i = 0; i <= s; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dfs(0, 1, 0);
        System.out.println(answer);
    }

    static void dfs(int cnt, int emotion, int copy) {
        // ++ 현재 이모티콘 상황의 최소 연산보다 크면, 굳이 이후 계산을 할 필요가 없음
        if (dp[copy][emotion] <= cnt) return;
        dp[copy][emotion] = cnt;

        if (cnt >= answer) return;
        if (emotion == s) {
            answer = Math.min(answer, cnt);
            return;
        } else if (emotion > s) {
            answer = Math.min(answer, cnt + (emotion - s));
            return;
        }

        dfs(cnt + 2, 2 * emotion, emotion);
        if (copy != 0) dfs(cnt + 1, emotion + copy, copy);
        if (emotion > 1) dfs(cnt + 1, emotion - 1, copy);
    }
}
