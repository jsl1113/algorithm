package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1105_팔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String l = st.nextToken();
        String r = st.nextToken();

        if(l.length() != r.length()){
            System.out.println(0);
            return;
        }

        int idx = 0, answer = 0;
        while (idx < l.length() && l.charAt(idx) == r.charAt(idx)) {
            if (l.charAt(idx) == '8') {
                answer++;
            }
            idx++;
        }

        System.out.println(answer);
    }
}
