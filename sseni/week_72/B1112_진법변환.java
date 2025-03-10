package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1112_진법변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (x == 0) {
            System.out.println(0);
            return;
        }

        boolean flag = false;
        if (x < 0 && b > 0) {
            x = -x;
            flag = true;
        }

        StringBuilder sb = new StringBuilder();
        while (x != 0) {
            long r = x % b;
            long q = x / b;

            if (r < 0) {
                r += Math.abs(b);
                q += 1;
            }

            sb.append(r);
            x = q;
        }

        String s = sb.reverse().toString();
        System.out.println(flag ? "-" + s : s);
    }
}
