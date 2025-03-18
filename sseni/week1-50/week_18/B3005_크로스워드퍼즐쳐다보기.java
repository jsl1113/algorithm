package com.example.algorithm.study.week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B3005_크로스워드퍼즐쳐다보기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                arr[i][j] = c[j];
            }
        }

        ArrayList<String> list = new ArrayList<>();
        int n = 0;
        for (int i = 0; i < R; i++) {
            StringBuilder tmp = new StringBuilder();
            n = 0;
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == '#') {
                    if(n >= 2) list.add(tmp.toString());
                    n = 0;
                    tmp = new StringBuilder();
                } else {
                    tmp.append(arr[i][j]);
                    n++;
                }
            }

            if(tmp.length() >= 2) list.add(tmp.toString());
        }

        for (int i = 0; i < C; i++) {
            StringBuilder tmp = new StringBuilder();
            n = 0;
            for (int j = 0; j < R; j++) {
                if (arr[j][i] == '#') {
                    if(n >= 2) list.add(tmp.toString());
                    n = 0;
                    tmp = new StringBuilder();
                } else {
                    tmp.append(arr[j][i]);
                    n++;
                }
            }

            if(tmp.length() >= 2) list.add(tmp.toString());
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
