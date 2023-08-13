package com.example.javaproject3.psstudy;

import java.util.*;

public class Solution81302_BFS {
    static final int dx[] = {0, 0, 1, -1};
    static final int dy[] = {1, -1, 0, 0};
    static int[][] visit;
    static char[][] map;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);  // 1 로 초기화
        int idx = 0;

        for (String[] place : places) {  // 대기실 마다
            visit = new int[5][5];
            map = new char[5][5];

            for(int i=0; i<5; i++)  // map 에 대기실 별로 저장
                map[i] = place[i].toCharArray();

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[i][j] == 'P') { // 해당 위치가 사람일 때
                        if (!bfs(i, j)) {  // bfs 탐색
                            answer[idx] = 0;  // 거리두기를 지키지 않았으므로 0 저장
                            break;
                        }
                    }
                }
            }
            idx++;
        }

        return answer;
    }

    static boolean bfs(int x, int y) {  // bfs 로 거리두기 준수 여부 확인하여 boolean 으로 반환
        Queue<Point> q = new LinkedList<>();
        visit = new int[5][5];

        for (int i = 0; i < 5; i++)  Arrays.fill(visit[i], -1);

        q.add(new Point(x, y)); // 큐에 탐색하고자 하는 위치 추가
        visit[x][y] = 0;
        while (!q.isEmpty()) { // 큐가 빌 때까지 탐색
            Point point = q.poll();
            x = point.x;
            y = point.y;

            for (int k = 0; k < 4; k++) {  // 해당 위치의 상하좌우 탐색
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {  // nx, ny 가 범위 안일 때
                    if (map[nx][ny] != 'X' && visit[nx][ny] == -1) {
                        visit[nx][ny] = visit[x][y] + 1;
                        if (map[nx][ny] == 'P' && visit[nx][ny] <= 2)  // 주변에 맨해튼 거리가 2 이상이고 사람일 때
                            return false; // 거리두기 준수하지 않았으므로 false 리턴
                        q.add(new Point(nx, ny));  // 큐에 주변 좌표 추가
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
