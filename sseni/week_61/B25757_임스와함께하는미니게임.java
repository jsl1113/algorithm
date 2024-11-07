package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B25757_임스와함께하는미니게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char c = st.nextToken().charAt(0);

        int t = -1;
        switch (c) {
            case 'Y' -> t = 1;
            case 'F' -> t = 2;
            case 'O' -> t = 3;
        }

        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(br.readLine());
        }

        System.out.println(hs.size() / t);
    }
}
