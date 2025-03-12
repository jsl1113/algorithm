package com.example.algorithm.study.week_18;

import java.util.*;

// 해당 구역 idx 를 따로 저장해놓고,
// map 에 idx 에 따른 size 값을 저장해놓음
// set 으로 해당 시추관의 idx 들을 저장하고, 합산
public class P242259_석유시추 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Map<Integer, Integer> map = new HashMap<>();
    static int n, m;

    static public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;

        // 석유 구역끼리 index 로 그룹화
        int[][] arr = bfs(land);
        for (int j = 0; j < m; j++) {
            Set<Integer> set = new HashSet<>();
            int max = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i][j] == 0) continue;
                set.add(arr[i][j]);
            }

            max = set.stream().mapToInt(map::get).sum();
            answer = Math.max(answer, max);
        }

        return answer;
    }

    static int[][] bfs(int[][] land) {
        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int idx = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(land[i][j] == 0 || visited[i][j]) continue;
                visited[i][j] = true;
                arr[i][j] = idx;

                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                int cnt = 0;
                while (!queue.isEmpty()) {
                    int[] point = queue.poll();
                    cnt++;

                    for (int d = 0; d < 4; d++) {
                        int x = point[0] + dx[d];
                        int y = point[1] + dy[d];

                        if(x < 0 || x >= n || y < 0 || y >= m) continue;
                        if(visited[x][y] || land[x][y] == 0) continue;

                        visited[x][y] = true;
                        arr[x][y] = idx;
                        queue.add(new int[]{x, y});
                    }
                }

                map.put(idx++, cnt);
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        }));  // 9
        System.out.println(solution(new int[][]{
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1}
        }));  // 16
    }
}
