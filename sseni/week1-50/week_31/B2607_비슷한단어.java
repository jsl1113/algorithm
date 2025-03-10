package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class B2607_비슷한단어 {
    static List<HashMap<Character, Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            HashMap<Character, Integer> hm = new HashMap<>();
            for (int j = 0; j < s.length(); j++) {
                hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0) + 1);
            }

            list.add(hm);
        }

        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (isSimilar(list.get(0), list.get(i))) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean isSimilar(HashMap<Character, Integer> targetHm, HashMap<Character, Integer> hm) {
        // 알파벳 차이 2 이하 && 길이 차이가 1 이하일 때 true
        int diff = 0, targetLen = 0, len = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            int x = targetHm.getOrDefault(c, 0);
            int y = hm.getOrDefault(c, 0);

            targetLen += x;
            len += y;

            diff += Math.abs(x - y);
        }

        return diff <= 2 && Math.abs(targetLen - len) <= 1;
    }
}
