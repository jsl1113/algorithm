package com.example.algorithm.study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 전체적으로 불필요한 과정이 많았던 거 같다. testCase 를 굳이 저장한다던지?
// 전 코드 과정의 DFS에서, cutting 해야 할 부분을 고려하지 않았던 점이 시간 초과를 만들지 않았을까 추측
public class B15661 {
    // https://www.acmicpc.net/problem/15661
    // 1. 될 수 있는 팀의 경우의 수 뽑기, 부분 집합 구하기 -> bitmask
    // 2. 각 경우마다 팀 능력치 합 구하기
    // point. 비트마스킹은? -> 부분 집합 과정 위해

    static int n, minNum;
    static int[][] ability;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ability = new int[n + 1][n + 1];
        minNum = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // ex. n이 6이면,  1 << 5 = 100000 = 32
        // 31 가지의 케이스가 있음
        for (int i = 1; i < (1 << n - 1); i++) {
            List<Integer> startList = new ArrayList<>();
            List<Integer> linkList = new ArrayList<>();

            for (int j = 0; j < n; j++) {  // i 가 5(101)일 때,  0 ~ 6까지 수 중에서,
                // j = 0 : 101 & 001 = 1 -> 1은 start
                // j = 1 : 101 & 010 = 0 -> 2는 link
                // j = 2 : 101 & 100 = 4 -> 3은 start
                // j = 3 : 0101 & 1000 = 0 -> 4는 link
                // j = 4 : 00101 & 10000 = 0 -> 5는 link
                // j = 5 : 000101 & 100000 = 0 -> 6은 link
                // start: 1,3, link: 2,4,5,6
                if ((i & 1 << j) != 0) startList.add(j + 1);
                else linkList.add(j + 1);
            }
            if (startList.size() == 1 || startList.size() == n - 1) continue;
            minNum = Math.min(minNum, Math.abs(getScore(startList) - getScore(linkList)));
        }
        System.out.println(minNum);
    }

    public static int getScore(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                sum += ability[list.get(i)][list.get(j)] + ability[list.get(j)][list.get(i)];
            }
        }
        return sum;
    }
}
