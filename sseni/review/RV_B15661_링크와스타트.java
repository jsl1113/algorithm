package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RV_B15661 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= (1 << n - 1); i++) {
            List<Integer> link = new ArrayList<>();
            List<Integer> start = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) link.add(j+1);
                else start.add(j+1);
            }
            if(link.size() == 1 || start.size() == 1) continue;
            answer = Math.min( getSum(arr, start, link), answer);
        }

        System.out.println(answer);
    }

    public static int getSum(int[][] arr, List<Integer> start, List<Integer> link) {
        int s = 0;
        for (int i = 0; i < start.size(); i++) {
            for (int j = i + 1; j < start.size(); j++) {
                s += arr[start.get(i)][start.get(j)] + arr[start.get(j)][start.get(i)];
            }
        }

        int l = 0;
        for (int i = 0; i < link.size(); i++) {
            for (int j = i + 1; j < link.size(); j++) {
                l += arr[link.get(i)][link.get(j)] + arr[link.get(j)][link.get(i)];
            }
        }

        return Math.abs(s - l);
    }
}
