package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B22233_가희와키워드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Boolean> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(br.readLine(), true);
        }

        int answer = n;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                if (hm.containsKey(s)) {
                    hm.remove(s);
                    answer--;
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
