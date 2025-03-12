package com.example.algorithm;

import java.io.*;
import java.util.*;

public class B1956_운동 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] arr = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            Arrays.fill(arr[i], 111_111_111);
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[a][b] = t;
        }

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            answer = Math.min(answer, arr[i][i]);
        }

        System.out.println(answer >= 111_111_111 ? -1 : answer);
    }
}
