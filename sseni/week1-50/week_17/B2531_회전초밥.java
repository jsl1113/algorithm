package com.example.algorithm.study.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연속해서 먹는 접시 경우의 수를 구하려고 했다가 써렌하고, 투포인터로 갈아탐..
// end = (start + k - 1) % n 라고 표현해도 됨, 윈도우 길이(k)가 고정이기 때문에
// 윈도우 만큼씩 옮겨가며 개수 갱신하기
public class B2531_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int[] eat = new int[d + 1]; // 초밥 가짓수
        for (int i = 0; i < k; i++) {  // 처음 k개만큼 먹었을 때의 가짓수 계산
            eat[arr[i]]++;
            if (eat[arr[i]] == 1) cnt++;
        }
        int answer = cnt;

        int start = 0, end = k; // 0 ~ k-1 번까지의 가짓수로 초기화 후, k부터 시작
        while (start != n){
            if(--eat[arr[start]] == 0) cnt--;
            if(++eat[arr[end]] == 1) cnt++; // 새로운 종류의 초밥이면, +1

            answer = Math.max(answer, (eat[c] == 0) ? cnt + 1 : cnt);
            start++; end++;
            end %= n;
        }

        System.out.println(answer);
    }
}
