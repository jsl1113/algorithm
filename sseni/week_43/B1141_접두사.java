package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B1141_접두사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        int answer = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = true;

            for (int j = i+1; j < n; j++) {
                if (arr[j].startsWith(arr[i])) {
                    flag = false;
                    break;
                }
            }

            if(flag) answer++;
        }

        System.out.println(answer);
    }
}
