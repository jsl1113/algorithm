package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15683_감시 {
    static int N, M;
    static List<CCTV> cctv;
    static int min = Integer.MAX_VALUE;
    static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 우, 하, 좌, 상

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctv.add(new CCTV(map[i][j], j, i));
                }
            }
        }

        dfs(0, map);
        System.out.println(min);
    }

    public static void dfs(int depth, int[][] map) {
        if (depth == cctv.size()) {
            min = Math.min(min, countBlindSpots(map));
            return;
        }

        CCTV current = cctv.get(depth);
        int[][] tmp;

        for (int[][] directionsSet : getDirections(current.type)) {
            tmp = copyMap(map);
            for (int[] dir : directionsSet) {
                monitor(tmp, current.x, current.y, dir);
            }
            dfs(depth + 1, tmp);
        }
    }

    /* TODO: CCTV 방향 설정 */
    public static List<int[][]> getDirections(int type) {
        List<int[][]> result = new ArrayList<>();
        switch (type) {
            case 1 -> {
                for (int i = 0; i < 4; i++) { // 우 / 하 / 좌 / 상
                    result.add(new int[][]{dir[i]});
                }
            }
            case 2 -> {
                result.add(new int[][]{dir[0], dir[2]}); // 우, 좌
                result.add(new int[][]{dir[1], dir[3]}); // 하, 상
            }
            case 3 -> {
                for (int i = 0; i < 4; i++) { // 우, 하 / 하, 좌 / 좌, 상 / 상, 우
                    result.add(new int[][]{dir[i], dir[(i + 1) % 4]});
                }
            }
            case 4 -> {
                for (int i = 0; i < 4; i++) { // 우, 하, 좌 / 하, 좌, 상 / 좌, 상, 우 / 상, 우, 하
                    result.add(new int[][]{dir[i], dir[(i + 1) % 4], dir[(i + 2) % 4]});
                }
            }
            case 5 -> result.add(new int[][]{dir[0], dir[1], dir[2], dir[3]});
        }
        return result;
    }

    /*Todo: 감시 영역 표시 */
    public static void monitor(int[][] map, int x, int y, int[] dir) {
        int nx = x + dir[0];
        int ny = y + dir[1];

        // -1 로 감시 영역 표시, 벽 만나면 중단
        while (nx >= 0 && ny >= 0 && nx < M && ny < N && map[ny][nx] != 6) {
            if (map[ny][nx] == 0) {
                map[ny][nx] = -1;
            }
            nx += dir[0];
            ny += dir[1];
        }
    }

    /*Todo: 사각지대 계산 */
    public static int countBlindSpots(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                count += map[i][j] == 0 ? 1 : 0;
            }
        }
        return count;
    }

    public static int[][] copyMap(int[][] map) {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, tmp[i], 0, M);
        }
        return tmp;
    }

    static class CCTV {
        int type, x, y;

        public CCTV(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }
}
