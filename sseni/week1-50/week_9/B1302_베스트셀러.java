package com.example.algorithm.study.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1302_베스트셀러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            list.add(str);
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }

        Collections.sort(list);

        String answer = "";
        int max = Integer.MIN_VALUE;
        for (String title : list) {
            if (max < hm.get(title)) {
                answer = title;
                max = hm.get(title);
            }
        }

        System.out.println(answer);
    }
}
