package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 위상정렬
 * 방향을 지키면서 순서대로 나열한다 */
public class B2056_작업 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        int[] cost = new int[n];    // 시간
        int[] degree = new int[n];  // 선행 작업 개수
        int[] answer = new int[n];  // 완료 시점
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            degree[i] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < degree[i]; j++) {
                list[Integer.parseInt(st.nextToken()) - 1].add(i);
            }
        }

        // 시작 가능한 작업들 큐에 추가
        for (int i = 0; i < n; i++) {
            if(degree[i] == 0) {
                queue.offer(i);
                answer[i] = cost[i];
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : list[current]) {
                // 선행 작업의 완료 시점과 현재 소요시간 중 최댓값 갱신
                answer[next] = Math.max(answer[next], answer[current] + cost[next]);
                if (--degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        System.out.println(Arrays.stream(answer).max().orElse(0));
    }
}
