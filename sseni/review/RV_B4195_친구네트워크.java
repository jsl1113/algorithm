package com.example.algorithm.study.review.week16_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// rank 가 있는 union-find
public class RV_B4195_친구네트워크 {
    static int T, F;
    static int[] parent, rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            F = Integer.parseInt(br.readLine());

            parent = new int[2 * F + 1];
            for (int i = 0; i < 2 * F; i++) parent[i] = i;

            rank = new int[2 * F + 1];
            Arrays.fill(rank, 1);

            int idx = 1;
            HashMap<String, Integer> hm = new HashMap<>();
            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (!hm.containsKey(a)) hm.put(a, idx++);
                if (!hm.containsKey(b)) hm.put(b, idx++);

                union(hm.get(a), hm.get(b));
                sb.append(rank[find(hm.get(a))]).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
            rank[a] += rank[b];
        }
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
