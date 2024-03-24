package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16997_배열복원하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] bArr = new int[H + X][W + Y];
        for (int i = 0; i < H + X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W + Y; j++) {
                bArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] aArr = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                aArr[i][j] = bArr[i][j];

                if (i - X >= 0 && j - Y >= 0) {
                    aArr[i][j] -= aArr[i - X][j - Y];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(aArr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
