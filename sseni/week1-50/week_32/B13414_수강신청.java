package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 순서를 보장하는 HashSet -> LinkedHashSet
public class B13414_수강신청 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> hs = new LinkedHashSet<>();
        for (int i = 0; i < L; i++) {
            String str = br.readLine();
            if(hs.contains(str)) hs.remove(str);
            hs.add(str);
        }

        StringBuilder sb = new StringBuilder();
        for (String str : hs) {
            sb.append(str).append("\n");
            if(--K == 0) break;
        }

        System.out.println(sb);
    }
}
