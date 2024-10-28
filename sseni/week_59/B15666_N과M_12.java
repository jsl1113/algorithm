package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B15666_N과M_12 {
    static int n, m;
    static int[] arr;
    static Set<List<Integer>> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0, new ArrayList<>());

        List<List<Integer>>  answer = new ArrayList<>(set);
        Collections.sort(answer, (o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                if (!o1.get(i).equals(o2.get(i))) {
                    return Integer.compare(o1.get(i), o2.get(i));
                }
            }
            return 0;
        });


        for (List<Integer> list : answer) {
            for (int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int start, int depth, List<Integer> list) {
        if (depth == m) {
            set.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < n; i++) {
            list.add(arr[i]);
            dfs(i, depth + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
