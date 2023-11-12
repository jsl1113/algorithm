package com.example.algorithm.study.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 후진 : D-2, 전진: D+1
public class B14503_로봇청소기 {
    static int n, m, d, r, c, answer = 1;
    static int[][] arr;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        init();
        clean();
//        dfs(r, c, d);
        System.out.println(answer);
    }

    static void clean() {
        int nowR = r;
        int nowC = c;
        int nowD = d;

        int flag = 0;
        while (true) {
            int D = (nowD + 3) % 4;
            int R = nowR + dr[D];
            int C = nowC + dc[D];

            if (arr[R][C] == 0) {
                arr[R][C] = 2;
                nowR = R;
                nowC = C;
                nowD = D;
                flag = 0;
                answer++;
            } else {
                nowD = D;
                flag++;
            }

            if (flag == 4) {  // 네 방향 모두 청소되어 있거나 벽일 때
                int backD = (nowD + 2) % 4;
                int backR = nowR + dr[backD];
                int backC = nowC + dc[backD];

                if (arr[backR][backC] == 1) break;
                else {
                    nowR = backR;
                    nowC = backC;
                    flag = 0;
                }
            }
        }
    }

    static void dfs(int r, int c, int d) {
        arr[r][c] = 2;

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && arr[nr][nc] == 0) {
                answer++;
                dfs(nr, nc, d);
                return;
            }
        }

        int back = (d + 2) % 4;
        int br = r + dr[back];
        int bc = c + dc[back];
        if (br >= 0 && br < n && bc >= 0 && bc < m && arr[br][bc] != 1) {
            dfs(br, bc, d);
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
