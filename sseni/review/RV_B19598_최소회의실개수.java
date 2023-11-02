package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// (우선순위 큐에 저장된) 진행 중인 회의 끝나는 시간과 다음 회의 시작 시간 비교
public class RV_B19598_최소회의실개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        System.out.println(solution(n, list));
    }

    static int solution(int n, List<int[]> list) {
        int answer = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list.get(0)[1]);
        for (int i = 1; i < n; i++) {
            while (!pq.isEmpty() && pq.peek() <= list.get(i)[0]) {
                pq.poll();
            }
            pq.add(list.get(i)[1]);
            answer = Math.max(answer, pq.size());
        }

        return answer;
    }
}
