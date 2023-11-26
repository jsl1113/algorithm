package com.example.algorithm.study.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1063_킹 {
    static char[] king, stone;
    static int n;
    static String[] moves;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void solution() {
        for (int i = 0; i < n; i++) {
            char[] k = king.clone();
            char[] s = stone.clone();

            move(moves[i], k);  // 킹 이동
            if(!check(k)){  // 움직인 킹이 범위 안일 때
                if (Arrays.equals(k, s)) { // 킹과 돌의 위치가 같으면
                    move(moves[i], s); // 돌 이동

                    if (!check(s)) {  // 돌이 범위 안이면, 위치 갱신
                        king = k;
                        stone = s;
                    }
                } else king = k; // 위치가 안 같으면, 킹 위치만 갱신
            }
        }

        System.out.println(king);
        System.out.println(stone);
    }

    static boolean check(char[] c) {
        return (c[0] < 'A' || c[0] > 'H' || c[1] < '1' || c[1] > '8');
    }

    static void move(String str, char[] c) {
        switch (str) {
            case "R" -> c[0]++;
            case "L" -> c[0]--;
            case "B" -> c[1]--;
            case "T" -> c[1]++;
            case "RT" -> { c[0]++; c[1]++; }
            case "LT" -> { c[0]--; c[1]++; }
            case "RB" -> { c[0]++; c[1]--; }
            case "LB" -> { c[0]--; c[1]--; }
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        king = st.nextToken().toCharArray();
        stone = st.nextToken().toCharArray();
        n = Integer.parseInt(st.nextToken());
        moves = new String[n];
        for (int i = 0; i < n; i++) {
            moves[i] = br.readLine();
        }
    }
}
