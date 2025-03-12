package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < n; i++)
            hs.add(br.readLine());

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if(hs.contains(br.readLine())) // 해당 문자열이 hash에 포함되어 있으면
                cnt++;
        }

        System.out.println(cnt);
    }
}
