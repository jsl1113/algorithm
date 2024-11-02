package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1205_등수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if(n == 0){
            System.out.println(1);
            return;
        }

        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        if (n == p && score <= arr[arr.length - 1]) System.out.println(-1);
        else {
            int answer = 1;
            for (int i = 0; i < n; i++) {
                if(score < arr[i]) answer++;
                else break;
            }
            System.out.println(answer);
        }
    }
}
