package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B13023_ABCDE {
    static int n, m;
    static boolean flag;
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        flag = false;
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];

            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;

            if(flag) break;
        }

        System.out.println(flag ? 1 : 0);
    }

    static void dfs(int num, int cnt) {
        if (cnt == 5) { // ABCDE
            flag = true;
            return;
        }

        for (int next : list[num]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, cnt + 1);
                visited[next] = false;
            }
        }
    }
}
