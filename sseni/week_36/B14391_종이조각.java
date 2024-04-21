package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 0000 0000 ... 0000 ~ 1111 1111 ... 1111 까지의 ( k ) 모든 케이스를 구한다.
// 0: 가로, 1: 세로
public class B14391_종이조각 {
    static int n, m, arr[][];
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] strArray = br.readLine().split("");

            for (int j = 0; j < m; j++) {
                arr[i][j] = strArray[j].charAt(0) - '0';
            }
        }

        bitmasking();
        System.out.println(answer);
    }

    static void bitmasking() {
        // 가로
        for (int k = 0; k < (1 << (n * m)); k++) {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                int tmp = 0;

                for (int j = 0; j < m; j++) {
                    int bit = i * m + j;

                    if ((k & (1 << bit)) == 0) {
                        tmp = (tmp * 10 + arr[i][j]);
                    } else {
                        sum += tmp;
                        tmp = 0;
                    }
                }

                sum += tmp;
            }

            System.out.println();
            // 세로
            for (int j = 0; j < m; j++) {
                int tmp = 0;

                for (int i = 0; i < n; i++) {
                    int bit = i * m + j;

                    if ((k & (1 << bit)) > 0) {
                        tmp = (tmp * 10 + arr[i][j]);
                    } else {
                        sum += tmp;
                        tmp = 0;
                    }
                }

                sum += tmp;
            }

            System.out.println();
            answer = Math.max(answer, sum);
        }
    }
}
