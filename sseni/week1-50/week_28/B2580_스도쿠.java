package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// check 하는 함수를 짜놓고 고민,
// 값이 0일 때, 재귀를 돌리면서 칸을 채워나가는데,
// 만약, 한 칸이 될 수 있는 숫자 후보군이 여러개일 때 어떻게 구현해야될지를 몰랐다.
// (초기화+재귀호출로 해결)
public class B2580_스도쿠 {
    static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
    }

    static void dfs(int x, int y) {
        if (y == 9) {
            dfs(x + 1, 0);
            return;
        }

        if (x == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }

            System.out.println(sb);

            // 밑에서 재귀호출이 계속되므로, 강제 종료
            System.exit(0);
        }

        if (arr[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if(check(x, y, i)){
                    arr[x][y] = i;
                    dfs(x, y + 1);
                }
            }

            // 값을 이미 채웠지만, 다른 값이 정답일수도 있으므로,
            // arr[x][y] 값을 초기화
            arr[x][y] = 0;
            return;
        }

        dfs(x, y + 1);
    }

    static boolean check(int x, int y, int num) { // 가로, 세로, 구역에 num 이 있다면, false
        for (int i = 0; i < 9; i++) {
            if(arr[x][i] == num) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i][y] == num) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[x / 3 * 3 + i][y / 3 * 3 + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
