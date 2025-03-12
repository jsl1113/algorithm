package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;

public class B1461_도서관 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int answer = 0, tmp = 0;
        Integer[] plus = new Integer[n];
        Integer[] minus = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            Integer current = Integer.parseInt(st.nextToken());
            if (current > 0) {
                plus[i] = current;
                minus[i] = 0;
            } else {
                plus[i] = 0;
                minus[i] = Math.abs(current);
            }

            tmp = Math.max(tmp, Math.abs(current));
        }

        Arrays.sort(plus, Collections.reverseOrder());
        Arrays.sort(minus, Collections.reverseOrder());

        for (int i = 0; i < plus.length; i += m) {
            if (plus[i] == 0) break;
            answer += plus[i] * 2;
        }

        for (int i = 0; i < minus.length; i += m) {
            if(minus[i] == 0) break;
            answer += minus[i] * 2;
        }

        System.out.println(answer - tmp); // 제일 먼 거리 빼주기
    }
}
