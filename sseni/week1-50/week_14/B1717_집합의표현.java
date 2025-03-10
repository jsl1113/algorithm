package com.example.algorithm.study.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// union-find 1
public class B1717_집합의표현 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // make-set
        arr = new int[n + 2];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cal = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // union
            if (cal == 0) union(a, b);
            // find
            else sb.append(find(a) == find(b) ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }

    static int find(int x) {
        if(arr[x] == x) return x;
        else return arr[x] = find(arr[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) arr[b] = a;
    }
}
