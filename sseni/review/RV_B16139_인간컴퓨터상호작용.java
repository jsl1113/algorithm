package com.example.algorithm.study.review.week16_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RV_B16139_인간컴퓨터상호작용 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[][] arr = new int[s.length() + 1][26];
        arr[1][s.charAt(0) - 'a'] = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if(s.charAt(i) == j+'a') arr[i+1][j] = arr[i][j] + 1;
                else arr[i + 1][j] = arr[i][j];
            }
        }

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(arr[end + 1][c - 'a'] - arr[start][c - 'a']).append("\n");
        }
        System.out.println(sb);
    }
}
