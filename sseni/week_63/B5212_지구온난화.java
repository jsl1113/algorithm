package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주변에 땅이 2개 이상이면, 안 잠긴다
public class B5212_지구온난화 {
    static int r, c, minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = -1, maxY = -1;
    static int[][] arr, check;
    static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                arr[i][j] = ch[j] == '.' ? 0 : 1;
            }
        }

        check = new int[r][c]; // 땅 개수 체크
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx >= 0 && ny >= 0 && nx < r && ny < c && arr[nx][ny] == 1) {
                            check[i][j] += 1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(check[i][j] < 2){ // 땅 개수가 2개 이하면, 잠긴다
                    arr[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(arr[i][j] == 1){ // 최대, 최소 좌표 구하기
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                sb.append(arr[i][j] == 0 ? '.' : 'X');
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
