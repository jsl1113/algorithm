package com.example.algorithm;

import java.io.*;
import java.util.*;

// 이분탐색 + 그래프탐색
// 다리를 버틸 무게 계산을 이탐,
// 그 무게만큼 최대 물품 개수를 갱신하기가 그래프 탐색
public class B1939_중량제한 {
    static int n, m, start, end, x, y, answer = -1;
    static boolean[] visited;
    static ArrayList<Edge>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
            end = Math.max(end, c);
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        while (start <= end) {
            int mid = (start + end) / 2;

            visited = new boolean[n + 1];
            visited[x] = true;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(x);
            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (Edge e : list[current]) {
                    if(visited[e.num] || e.weight < mid) continue;

                    visited[e.num] = true;
                    queue.add(e.num);
                }
            }

            if(visited[y]){
                start = mid + 1;
                answer = mid;
            } else end = mid - 1;
        }

        System.out.println(answer);
    }

    static class Edge {
        int num, weight;

        Edge(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }
}
