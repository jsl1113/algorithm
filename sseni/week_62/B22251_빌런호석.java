package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1 층부터 9 층, k 자리수가 보임, 1 ~ p 개 반전시킬 수 있음, x 층에서 반전시킬 경우의 수
// 각 숫자가 다른 숫자가 되려면 몇 번을 반전해야 하는지 미리 저장
// 반전 최대 개수를 넘기면, return
// 자리수가 동일할 때, 0층 제외 카운트
// 0~9까지 가능한 숫자로 만들 수 있는 숫자를 만들어 반복 재귀
public class B22251_빌런호석 {
    static int n, k, p, x, answer;
    static int[][] arr = {
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        func(0, 1, 0, 0);

        System.out.println(answer - 1);
    }

    // cnt : 현재 자릿수
    // ten : 몇번째인지
    // now : 현재 숫자
    // sum : 반전 개수
    static void func(int cnt, int ten, int now, int sum) {
        if (now > n || sum > p) return;

        if (cnt == k) {
            if (now != 0) answer++;
            return;
        }

        for (int i = 0; i < 10; i++) {
            func(cnt + 1, ten * 10, i * ten + now, sum + arr[x / ten % 10][i]);
        }
    }
}
