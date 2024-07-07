package com.example.algorithm.study.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// dfs + set 은 메모리초과가 된다
// 알파벳 카운트로
public class B6443_애너그램 {
    static int n, len;
    static int[] alphabet;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            alphabet = new int[26];
            for (int j = 0; j < str.length(); j++) {
                alphabet[str.charAt(j) - 'a']++;
            }

            len = str.length();
            dfs(new ArrayList<>());
        }

        System.out.println(sb);
    }

    static void dfs(List<Character> list) {
        if (list.size() == len) {
            sb.append(list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining())).append("\n");
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > 0) {
                alphabet[i]--;
                list.add((char) (i + 'a'));
                dfs( list);
                alphabet[i]++;
                list.remove(list.size() - 1);
            }
        }
    }
}
