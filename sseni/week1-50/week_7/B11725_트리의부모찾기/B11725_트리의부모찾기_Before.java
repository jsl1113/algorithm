package com.example.algorithm.study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 예제 대로 값이 나오긴 했는데 알고리즘 자체가 틀린 거 같다. (while문에서 cnt가 n보다 커질 수 있음)
// DFS 써야한다고 뇌는 알고 있었는데 풀다보니까 내 멋대로 풀게 되네 ..
// GPT 왈, 각 노드를 처리할 때마다 모든 간선을 검사하고 부모를 찾는 방식은 비효율적
public class B11725_Before {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }

        int[] parent = new int[n + 1];
        for (int i = 0; i < list.get(1).size(); i++) {
            parent[list.get(1).get(i)] = 1;
        }

        int cnt = 0;
        while (cnt <= n) {
            for (int i = 2; i <= n; i++) {
                List<Integer> edge = list.get(i);

                if (edge.size() == 1) {
                    parent[i] = edge.get(0);
                    cnt++;
                }
                else if (edge.size() >= 2) {
                    for (int j = 0; j < edge.size(); j++) {
                        if (parent[edge.get(j)] == i) {
                            edge.remove(j);
                            j -= 1;
                        }
                    }
                }
            }
        }

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }
}