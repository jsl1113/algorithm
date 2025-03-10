package com.example.algorithm.study.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// count()에서 공기청정기 값을 2번 더했으므로 2를 더해줌
public class B17144_미세먼지안녕 {
    static int R, C, T;
    static int[] air = new int[2];
    static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution() + 2);
    }

    static int solution() {
        for (int i = 0; i < T; i++) {
            arr = dustSimulation(); // 먼지 퍼져나가기
            airSimulation(); // 공기청정기로 먼지가 들어오며 나가기
        }

        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result += arr[i][j];
            }
        }

        return result;
    }

    static void airSimulation() {
        int top = air[0];
        for (int i = top - 1; i > 0; i--) arr[i][0] = arr[i - 1][0];
        for (int i = 0; i < C - 1; i++) arr[0][i] = arr[0][i + 1];
        for (int i = 0; i < top; i++) arr[i][C - 1] = arr[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--) arr[top][i] = arr[top][i - 1];
        arr[top][1] = 0;

        int bottom = air[1];
        for (int i = bottom + 1; i < R - 1; i++) arr[i][0] = arr[i + 1][0];
        for (int i = 0; i < C - 1; i++) arr[R - 1][i] = arr[R - 1][i + 1];
        for (int i = R - 1; i > bottom; i--) arr[i][C - 1] = arr[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) arr[bottom][i] = arr[bottom][i - 1];
        arr[bottom][1] = 0;
    }

    static int[][] dustSimulation() {
        int[][] tmp = new int[50][50];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == -1) {
                    tmp[i][j] = -1;
                    continue;
                }

                tmp[i][j] += arr[i][j];
                for (int k = 0; k < 4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];

                    if(ny <0 || ny >= R || nx < 0 || nx >= C) continue;
                    if(arr[ny][nx] == -1) continue;

                    tmp[ny][nx] += (arr[i][j] / 5);
                    tmp[i][j] -= (arr[i][j] / 5);
                }
            }
        }

        return tmp;
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            if (arr[i][0] == -1) {
                air[0] = i;
                air[1] = i + 1;
                break;
            }
        }
    }
}