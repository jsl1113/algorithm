package com.example.javaproject3.psstudy;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1844 {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    int[][] visit;
    int n, m;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visit = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});  // 시작 지점 큐에 삽입 (편의상 0, 0)
        visit[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 4; i++) {
                int x = nx + dx[i];
                int y = ny + dy[i];

                // 맵 안 좌표 + 아직 방문하지 않은 곳 + 벽에 부딪히지 않을 때
                if (x >= 0 && x < n && y >= 0 && y < m && visit[x][y] == 0 && maps[x][y] == 1) {
                    queue.add(new int[]{x, y});
                    visit[x][y] = visit[nx][ny] + 1;  // 이전에 방문한 칸 값 + 카운트
                }
            }
        }

        return visit[n - 1][m - 1] > 0 ? visit[n - 1][m - 1] : -1; // 상대방 진영에 도달했을 때의 카운트 값 리턴
    }

    public static void main(String[] args) {
        System.out.println(new Solution1844().solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    }
}
