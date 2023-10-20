package com.example.algorithm.study.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 스케줄링 문제 풀면서 우선순위 큐 많이 썼는데,
// 오랜만에 봐서 그런지, while 문이 생각나지 않았따 ..
// 다시 풀면 무조건 가능
public class B19598_최소회의실개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(list.get(0)[1]);
        int answer = 1;
        for (int i = 1; i < n; i++) {
            // pq.peek() : 가장 빨리 끝나는 회의 시간
            // 현재 회의의 시작 시간이 더 크면, 같은 회의실 쓸 수 있다.
            while (!pq.isEmpty() && pq.peek() <= list.get(i)[0]) {
                pq.poll();
            }

            pq.offer(list.get(i)[1]);
            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);
    }
}
