package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1916_최소비용구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Node>[] list = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int city = node.city;
            int cost = node.cost;

            if(cost > arr[city]) continue;

            for (Node next : list[city]) {
                int nCity = next.city;
                int nCost = cost + next.cost;

                if (nCost < arr[nCity]) {
                    arr[nCity] = nCost;
                    pq.offer(new Node(nCity, nCost));
                }
            }
        }

        System.out.println(arr[end]);
    }

    static class Node {
        int city, cost;

        Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }
}
