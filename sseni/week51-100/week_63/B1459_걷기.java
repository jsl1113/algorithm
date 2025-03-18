package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1459_걷기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long answer = (x + y) * w;
        if ((x + y) % 2 == 0) {
            answer = Math.min(answer, Math.max(x, y) * s);
        } else {
            answer = Math.min(answer, (Math.max(x, y) - 1) * s + w);
        }

        System.out.println(Math.min(answer, (Math.min(x, y)) * s + (Math.abs(x - y)) * w));
    }
}
