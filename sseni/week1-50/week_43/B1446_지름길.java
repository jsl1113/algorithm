package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1446_지름길 {
    static int answer, n, d;
    static List<Street> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            if (end <= d && end - start > len) {
                list.add(new Street(start, end, len));
            }
        }

        answer = Integer.MAX_VALUE;
        func(0, 0);
        System.out.println(answer);
    }

    static void func(int value, int cost) {
        if (cost >= answer) return;
        if (value == d) {
            answer = cost;
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            Street street = list.get(i);

            if (street.s == value) {
                func(street.e, cost + street.len); // 지름길 이용
            }
        }

        func(value + 1, cost + 1); // 그냥 가기
    }

    static class Street {
        int s, e, len;

        Street(int s, int e, int len) {
            this.s = s;
            this.e = e;
            this.len = len;
        }
    }
}
