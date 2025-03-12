package com.example.algorithm.study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B15661_Before {
    static int n, minNum;
    static int[][] ability;
    static List<List<Integer>> testCase;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ability = new int[n + 1][n + 1];
        testCase = new ArrayList<>();
        minNum = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < (1 << n); i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 1; j < n; j++) {
                if ((i & 1 << j) != 0) tmp.add(j);
            }
            if (!tmp.isEmpty() && tmp.size() != n && tmp.size() != 1 && tmp.size() != (n - 1) && !testCase.contains(tmp))
                testCase.add(tmp);
        }

        for (int i = 0; i < testCase.size(); i++) {
            List<Integer> startList = testCase.get(i);
            List<Integer> linkList = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (!startList.contains(j)) linkList.add(j);
            }

            // 스타트, 링크 각각의 능력치 합 구하기
            int[] answer = new int[]{dfs(startList, 0, 0), dfs(linkList, 0, 0)};
            minNum = Math.min(minNum, Math.abs(answer[0] - answer[1]));
        }

        System.out.println(minNum);
    }

    public static int dfs(List<Integer> list, int idx, int start) { // list 에서 두 개씩 조합으로 뽑기 (dfs)
        if (list.size() == 2) {
            return ability[list.get(0)][list.get(1)] + ability[list.get(1)][list.get(0)];
        }

        int sum = 0;
        for (int i = start; i < list.size(); i++) {
            List<Integer> nextList = new ArrayList<>(list);
            nextList.remove(i);
            sum += dfs(nextList, idx + 1, i);
        }
        return sum;
    }

}
