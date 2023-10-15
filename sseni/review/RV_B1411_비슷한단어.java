package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RV_B1411_비슷한단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            char c = 'a';
            StringBuilder tmp = new StringBuilder();
            HashMap<Character, Character> hm = new HashMap<>();
            for (int j = 0; j < str.length(); j++) {
                if (!hm.containsKey(str.charAt(j))) {
                    hm.put(str.charAt(j), c);
                    tmp.append(hm.get(str.charAt(j)));
                    c++;
                } else {
                    tmp.append(hm.get(str.charAt(j)));
                }
            }
           arr[i] = tmp.toString();
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i].equals(arr[j])) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
