package com.example.algorithm.study.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 1. 스티커 고르기 - dfs
// 2. 붙일 수 있는지 확인
// 2-1. 최댓값 갱신
public class B16937_두스티커 {
    static int h, w, n, max = 0;
    static boolean[] visited;
    static List<Sticker> list;

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, 0);
        System.out.println(max);
    }

    static void dfs(int start, int cnt) {
        if (cnt == 2) {
            // 되는 스티커인지 & 최댓값 갱신
            List<Sticker> sticker = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if(visited[i]) sticker.add(list.get(i));
            }
            solution(sticker.get(0), sticker.get(1));
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, cnt + 1);
                visited[i] = false;
            }
        }
    }

    static void solution(Sticker s1, Sticker s2) {
        boolean flag = false;

        // 4가지 경우 체크 - 그대로, 1번 회전, 2번 회전, 둘다 회전
        if (check(s1.h, s1.w, s2.h, s2.w) || check(s1.w, s1.h, s2.h, s2.w) ||
                check(s1.h, s1.w, s2.w, s2.h) || check(s1.w, s1.h, s2.w, s2.h)) {
            flag = true;
        }

        if (flag) max = Math.max(max, s1.h * s1.w + s2.h * s2.w);
    }

    static boolean check(int h1, int w1, int h2, int w2) {
        if ((h1 + h2 <= h && Math.max(w1, w2) <= w) ||
                (Math.max(h1, h2) <= h && w1 + w2 <= w)) return true;
        else return false;
    }

    static class Sticker {
        int h, w;

        Sticker(int h, int w) {
            this.h = h;
            this.w = w;
        }

        public String toString() {
            return "<" + h + ", " + w + ">";
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Sticker(r, c));
        }
        visited = new boolean[n];
    }
}
