package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2170_선긋기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Pair[] lines = new Pair[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i] = new Pair(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lines);

        int answer = 0;
        int start = lines[0].x;
        int end = lines[0].y;

        for (Pair line : lines) {
            if (end < line.x) {  // 이전 선분과 연결되지 않은 경우
                answer += end - start;
                start = line.x;
                end = line.y;
            } else {
                end = Math.max(end, line.y);
            }
        }
        answer += end - start;

        System.out.println(answer);
    }

    static class Pair implements Comparable<Pair> {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return x == o.x ? y - o.y : x - o.x;
        }
    }
}
