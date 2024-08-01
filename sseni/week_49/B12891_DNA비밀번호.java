package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호 {
    static int s, p;
    static char[] dna;
    static HashMap<Character, int[]> hm = new HashMap<>(); // 1번: 필수 문자 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (char c : new char[]{'A', 'C', 'G', 'T'}) {
            hm.put(c, new int[]{0, Integer.parseInt(st.nextToken())});
        }

        for (int i = 0; i < p; i++) {
            hm.get(dna[i])[0]++;
        }

        int answer = 0;
        if(check()) answer++;

        for (int i = 0; i < s - p; i++) {
            hm.get(dna[i])[0]--;
            hm.get(dna[i + p])[0]++;
            if(check()) answer++;
        }

        System.out.println(answer);
    }

    static boolean check() {
        for (char c : new char[]{'A', 'C', 'G', 'T'}) {
            if(hm.get(c)[0] < hm.get(c)[1]) {
                return false;
            }
        }

        return true;
    }
}
