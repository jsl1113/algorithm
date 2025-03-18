package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B14426_접두사찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String>[] hs = new HashSet[501];
        for (int i = 0; i <= 500; i++) {
            hs[i] = new HashSet<>();
        }

        while (n-- > 0) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
                hs[sb.length()].add(sb.toString());
            }
        }

        int cnt = 0;
        while (m-- > 0) {
            String str = br.readLine();
            if (hs[str.length()].contains(str)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
