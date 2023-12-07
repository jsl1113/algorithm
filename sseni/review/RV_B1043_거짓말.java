package com.example.algorithm.study.review.week16_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class RV_B1043_거짓말 {
    static int[] parent;
    static int n, m;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int know = Integer.parseInt(st.nextToken());
        if (know == 0) {
            System.out.println(m);
            return;
        }

        list = new ArrayList<>();
        for (int i = 0; i < know; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer>[] partyLists = new List[m];
        for (int i = 0; i < m; i++) {
            partyLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num > 0) partyLists[i].add(Integer.parseInt(st.nextToken()));
            for (int j = 0; j < num - 1; j++) {
                partyLists[i].add(Integer.parseInt(st.nextToken()));
                int a = partyLists[i].get(j);
                int b = partyLists[i].get(j + 1);
                if (find(a) != find(b)) union(a, b);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!list.contains(i)) continue;

            int x = find(i);
            for (int j = 1; j <= n; j++) {
                if (i != j && find(j) == x && !list.contains(j)) {
                    list.add(j);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int x : partyLists[i]) {
                if (list.contains(x)) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }

        System.out.println(answer);
//        System.out.println(list);
//        System.out.println(Arrays.toString(parent));
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a > b) parent[a] = b;
            else parent[b] = a;
        }
    }
}
