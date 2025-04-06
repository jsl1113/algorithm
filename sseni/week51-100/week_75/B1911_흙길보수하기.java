package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1911_흙길보수하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a, b});
        }

        int cnt = 0, pos = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(cur[1] < pos) continue;
            if(cur[0] > pos) pos = cur[0];

            // 범위 넘어가면
            int tmp = (cur[1] - pos) % l;

            cnt += (cur[1] - pos) / l;
            pos = cur[1];

            if (tmp != 0) {
                cnt++;
                pos += l - tmp;
            }
        }

        System.out.println(cnt);
    }
}
