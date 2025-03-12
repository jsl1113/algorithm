package com.example.algorithm.study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 가장 적은 비용으로 어떤 전공책을 선택해야 하는지
// 이 문장에서 dfs 를 떠올리긴 했었는데
// 나는.. 문자열에 취약하다...
public class B16508 {
    static ArrayList<Book> arrayList = new ArrayList<>();
    static String str;
    static int[] cnt = new int[26];
    static int[] select = new int[26];
    static int n, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'A']++;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            String title = st.nextToken();
            arrayList.add(new Book(price, title));
        }

        dfs(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void dfs(int len, int total) {
        if (len == n) {
            if (check()) {
                min = Math.min(total, min);
            }
            return;
        }

        // 현재 책을 선택할 때
        for (int i = 0; i < arrayList.get(len).title.length(); i++) {
            select[arrayList.get(len).title.charAt(i) - 'A']++;
        }
        dfs(len+1, total + arrayList.get(len).price);

        // 선택하지 않을 때
        for (int i = 0; i < arrayList.get(len).title.length(); i++) {
            select[arrayList.get(len).title.charAt(i) - 'A']--;
        }
        dfs(len + 1, total);
    }

    static boolean check() {
        for (int i = 0; i < 26; i++) {
            if(cnt[i] > select[i]) return false;
        }
        return true;
    }

    public static class Book {
        int price;
        String title;

        public Book(int price, String title) {
            this.price = price;
            this.title = title;
        }
    }

}
