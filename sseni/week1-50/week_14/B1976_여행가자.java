package com.example.algorithm.study.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// union-find 2
// 여행 루트 안의 도시들이 서로 부모가 다를 경우,
// 불가능하다고 판단하는 것을 금방 알았고, 쉽게 풀었다
// 프로그래머스 카카오 문제 유파가 훨씬 어려웠었는데, 다시 풀면 쉽다고 느낄까?
// 함수 생긴 거 한 번 익히면 금방 푸는듯??
public class B1976_여행가자 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = makeSet(n);

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        String answer = "YES";
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        for (int i = 1; i < m; i++) {
            int b = Integer.parseInt(st.nextToken());
            if(find(a) != find(b)) {
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);
    }

    static int[] makeSet(int n) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        return parent;
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }

    static int find(int x) {
        if(x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }
}
