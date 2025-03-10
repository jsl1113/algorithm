package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1049_기타줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int unitPrice = 1000, setPrice = 1000;
        int price = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            setPrice = Math.min(setPrice, Integer.parseInt(st.nextToken()));
            unitPrice = Math.min(unitPrice, Integer.parseInt(st.nextToken()));
        }

        price = Math.min(price, (n / 6 + 1) * setPrice);
        price = Math.min(price, unitPrice * n);

        price = Math.min(price, ((n / 6) * setPrice) + ((n % 6) * unitPrice));
        System.out.println(price);
    }
}
