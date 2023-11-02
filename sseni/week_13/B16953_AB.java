package com.example.algorithm.study.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 보자마자 재귀 호출 두 번 하면 되겠구나 했다.
public class B16953_AB {
    static long a, b, answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        dfs(a, 1);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void dfs(long num, int cnt) {
        if (num > b) return;
        if (num == b) {
            answer = Math.min(answer, cnt);
            return;
        }

        dfs(2 * num, cnt + 1);
        dfs(num * 10 + 1, cnt + 1);
    }
}
