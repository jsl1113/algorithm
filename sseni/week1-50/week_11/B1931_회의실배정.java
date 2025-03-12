package com.example.algorithm.study.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 처음에 끝나는 시간로만 정렬했다가 85%에서 틀렸다.
/* (반례)
3
4 4
3 4
2 4
 */
public class B1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // 1. 끝나는 시간을 오름차순으로 정렬
        // 2. 끝나는 시간이 같다면, 시작하는 시간을 오름차순으로 정렬
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] != b[1] ? a[1] -  b[1] : a[0] - b[0];
            }
        });

        int answer = 1;
        int[] time = list.get(0);
        for (int i = 1; i < n; i++) {
            if(list.get(i)[0] < time[1]) continue;
            answer++;
            time = list.get(i);
        }

        System.out.println(answer);
    }
}
