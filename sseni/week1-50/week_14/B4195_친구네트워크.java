package com.example.algorithm.study.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// map 으로 각 사람을 인덱스화시킨다
// union 시,  트리의 높이를 갱신시키는 것에 초점
public class B4195_친구네트워크 {
    static int[] parent, rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());
            parent = new int[2 * F + 1];
            rank = new int[2 * F + 1];
            for (int i = 0; i < 2 * F; i++) {
                parent[i] = i;
                rank[i] = 1;
            }

            Map<String, Integer> map = new HashMap<>();
            int idx = 1;
            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (!map.containsKey(a)) map.put(a, idx++);
                if (!map.containsKey(b)) map.put(b, idx++);

                sb.append(union(map.get(a), map.get(b))).append("\n");
            }
//            System.out.println(Arrays.toString(parent));
//            System.out.println(Arrays.toString(rank));
        }

        System.out.println(sb);
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static int union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
            rank[a] += rank[b];
        }

        return rank[a];
    }
}
