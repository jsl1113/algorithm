package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class B1174_줄어드는수 {
    static int n;
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n > 1023) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < 10; i++) {
            func(i, i);
        }

        Collections.sort(list);
        System.out.println(n > list.size() ? -1 : list.get(n - 1));
    }

    static void func(int cnt, long num) {
        list.add(num);

        for (int i = 0; i < cnt; i++) {
            func(i, num * 10 + i);
        }
    }
}
