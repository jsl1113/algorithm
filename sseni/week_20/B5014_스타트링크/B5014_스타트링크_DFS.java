package com.example.algorithm.study.week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dfs 로 풀면 안 되는 문제 ㅠ (시간초과)
// 나중에 수행했던 경로가 더 짧을 수 있음
public class B5014_스타트링크_DFS {
    static int F, S, G, U, D, answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dfs(S, 0);
        System.out.println(answer == Integer.MAX_VALUE ? "use the stairs" : answer);
    }

    // S층에서 시작해서, G층까지 도달할 경우 정답 갱신
    // F층을 넘기거나, 1층 이하로 떨어지면 리턴
    static void dfs(int now, int cnt) {
        if(answer <= cnt) return;
        if(now > F || now < 1) return;
        if(now == G) {
            answer = cnt;
            return;
        }

        if(U > 0) dfs(now + U, cnt + 1);
        if(D > 0) dfs(now - D, cnt + 1);
    }
}
