package com.example.javaproject3.psstudy;

import java.util.LinkedList;
import java.util.Queue;

public class Solution43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;  // 네트워크의 개수
        boolean[] visit = new boolean[n]; // 방문 여부 확인 visit
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) { // 컴퓨터의 개수마다
            if (visit[i]) continue;

            visit[i] = true;
            queue.add(i); // 컴퓨터 초기값 큐에 저장
            while (!queue.isEmpty()) {
                Integer num = queue.poll();
                for (int j = 0; j < n; j++) { // 컴퓨터 개수마다
                    if (i != j && computers[num][j] == 1 && !visit[j]) { // 자기 자신이 아니고 방문하지 않은 컴퓨터이며 연결되어 있을 때
                        visit[j] = true; // 방문 처리
                        queue.add(j);
                    }
                }
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution43162().solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
}
