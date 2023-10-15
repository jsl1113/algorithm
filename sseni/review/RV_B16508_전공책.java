package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RV_B16508_전공책 {
    static ArrayList<Book> arrayList = new ArrayList<>();
    static String T;
    static int n;
    static int answer = Integer.MAX_VALUE;
    static HashMap<Character, Integer> tMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = br.readLine();
        tMap = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            tMap.put(T.charAt(i), tMap.getOrDefault(T.charAt(i), 0) + 1);
        }
        System.out.println(tMap);
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            String title = st.nextToken();
            arrayList.add(new Book(price, title));
        }

        dfs(0, 0, new HashMap<>());
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void dfs(int length, int prices, HashMap<Character, Integer> hm) {
        if (length == n) {
            boolean flag = true;

            for (int i = 0; i < T.length(); i++) { // ANTT
                if (!hm.containsKey(T.charAt(i)) ||
                        (hm.containsKey(T.charAt(i)) && hm.get(T.charAt(i)) < tMap.get(T.charAt(i)))) {
                    flag = false;
                }
            }

            if (flag) answer = Math.min(answer, prices);
            return;
        }

        // 해당 책을 골랐을 때, 안 골랐을 때
        for (int i = 0; i < arrayList.get(length).title.length(); i++) {
            char c = arrayList.get(length).title.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        dfs(length + 1, prices + arrayList.get(length).price, hm);

        for (int i = 0; i < arrayList.get(length).title.length(); i++) {
            char c = arrayList.get(length).title.charAt(i);
            hm.put(c, hm.get(c) - 1);
        }
        dfs(length + 1, prices, hm);
    }

    static class Book {
        String title;
        int price;

        public Book(int price, String title) {
            this.title = title;
            this.price = price;
        }
    }
}
