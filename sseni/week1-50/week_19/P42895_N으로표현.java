package com.example.algorithm.study.week19;

// N: 1 ~ 9 이하, 최솟값이 8보다 크면 -1 return
// DP 문제지만, 방법이 안 떠올라서 고민하다 답을 참고했는데,
// dp 보다 DFS 풀이 방식이 효율적인듯?
public class P42895_N으로표현 {
    static int min = Integer.MAX_VALUE;
    static int n, num;

    public static int solution(int N, int number) {
        n = N;
        num = number;

        dfs(0, 0);
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }

    static void dfs(int depth, int current) {
        if (depth > 8) return;
        if (num == current) {
            min = Math.min(depth, min);
            return;
        }

        int tmp = 0;
        for (int i = 0; i < 8; i++) {
            if (depth + i < 8) {
                tmp = tmp * 10 + n;
                dfs(depth + i + 1, current + tmp);
                dfs(depth + i + 1, current - tmp);
                dfs(depth + i + 1, current * tmp);
                dfs(depth + i + 1, current / tmp);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 12));
        System.out.println(solution(2, 11));
    }
}
