package com.example.algorithm.study.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// k 번째 사람을 제거한다.
public class B1158_요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {  // k-1 만큼 큐에서 빼내어 맨 뒤에 저장
                int num = queue.poll();
                queue.add(num);
            }

            sb.append(queue.poll()); // k 번째를 제거한다.
            if(!queue.isEmpty()) {  // 출력 형태 맞추기
                sb.append(", ");
            } else {
                sb.append(">");
            }
        }

        System.out.println(sb);
    }
}
