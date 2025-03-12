package com.example.algorithm.study.week22;

import java.util.Collections;
import java.util.PriorityQueue;

// 제곱 합이기 때문에, 가장 큰 수를 작업해야 함, 이걸 매 시간 마다 -> 우선순위 큐 이용
public class P12927_야근지수 {
    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{4, 3, 3}));
        System.out.println(solution(1, new int[]{2, 1, 2}));
    }

    public static long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : works) {
            pq.offer(num);
        }

        while (n-- > 0) {
            int max = pq.poll();
            if(max > 0) pq.offer(max - 1);
            else break;
        }

        while (!pq.isEmpty()) {
            int num = pq.poll();
            answer += ((long) num * num);
        }
        return answer;
    }

}
