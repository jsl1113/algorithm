package com.example.algorithm.study.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 진실을 아는 사람과 같은 파티원들을 그룹핑하는 것이 중요했다.
public class B1043_거짓말 {
    static int[] parent;
    static List<Integer> list;  // 진실을 아는 사람 & 그 아는 사람이랑 같은 파티원

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = makeSet(n);

        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int know = Integer.parseInt(st.nextToken());
        if (know == 0) {
            System.out.println(m);
            return;
        } else {
            for (int i = 0; i < know; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

        List<Integer>[] party = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");

            int num = Integer.parseInt(input[0]);
            if (num <= 1) {
                party[i].add(Integer.parseInt(input[1]));
                continue;
            }

            for (int j = 1; j < num; j++) {
                int a = Integer.parseInt(input[j]);
                int b = Integer.parseInt(input[j + 1]);
                if (find(a) != find(b)) union(a, b);
                party[i].add(a);
                party[i].add(b);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (list.contains(i)) {
                int root = find(i);
                for (int j = 1; j <= n; j++) {
                    if(i != j && find(j) == root) {
                        list.add(j); // 진실을 아는 사람이랑 같은 파티원도 리스트에 추가해줌
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int num : party[i]) {
                if (list.contains(find(parent[num]))) {
                    flag = false;
                    break;
                }
            }
            if(flag) cnt++;
        }

        // System.out.println(Arrays.toString(party));
        // System.out.println(list);
        // System.out.println(Arrays.toString(parent));
        System.out.println(cnt);
    }

    static int[] makeSet(int n) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        return parent;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }
}
