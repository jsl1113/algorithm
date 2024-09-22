package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B1038_감소하는수 {
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        if (n <= 10) System.out.println(n);
        else if (n > 1022) System.out.println(-1);
        else {
            for (int i = 0; i < 10; i++) {
                dfs(i, 1);
            }

            Collections.sort(list);
            System.out.println(list.get(n));
        }
    }

    static void dfs(int num, int cnt) {
        if(cnt > 10) return;

        list.add(num);

        for (int i = 0; i < 10; i++) {
            if (num % 10 > i) {
                dfs((num * 10) + i, cnt + 1);
            }
        }

        return;
    }
}
