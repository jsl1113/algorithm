package com.example.algorithm.study.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

// i 에서 j 로 이동 시, (j-i) * (Ai - Aj) 힘이 듦, 한 번 건널 때 최대 K 힘만 쓸 수 있음
// 1. 최대 거리를 이분 탐색하는 데, 해당 최대 거리일 때 건널 수 있는가? 를 판단
// 2. 건널 수 있다면, k 값 갱신하고 mid 값 조정
// 근데. 틀렸다. 한 6% ? 에서 틀린다.. 자료형이 틀렸을까, 알고리즘이 틀렸을까
public class B22871_징검다리건너기_Before {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).mapToInt(Integer::intValue).toArray();

        long start = 1, end = (long) (n - 1) * (1 + Math.abs(arr[n-1] - arr[0]));
        long result = 0;
        while (start < end) {
            long mid = (start + end) / 2;
//            System.out.println(mid);

            Stack<Integer> stack = new Stack<>();
            stack.add(0);
            boolean[] visited = new boolean[n];
            visited[0] = true;

            boolean flag = isCross(arr, mid, n, visited, stack);
            if (flag) {
                end = mid - 1;
                result = mid;
            } else start = mid + 1;
        }

        System.out.println(result);
    }

    public static boolean isCross(int[] arr, long mid, int n, boolean[] visited, Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            int k = stack.pop();
            if (k == n - 1) return true;

            for (int i = k; i < n; i++) {
                long tmp = (long) (i - k) * (1 + Math.abs(arr[i] - arr[k]));
                if (tmp <= mid && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }

        return false;
    }
}
