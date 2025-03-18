package com.example.algorithm.study.week19;

public class P87946_피로도 {
    static int answer = 0;
    static boolean[] visited;

    static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons);
        return answer;
    }

    static void dfs(int k, int cnt, int[][] dungeons) {
        answer = Math.max(answer, cnt);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], cnt + 1, dungeons);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}
