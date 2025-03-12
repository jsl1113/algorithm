package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 지나간 알파벳 체크를
// hashset, 문자열, boolean배열 세 가지로 해봤는데,
// boolean 배열 사용해서 체크하는 게 제일 효율적이었다.
public class B1987_알파벳 {
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static int r, c, answer = 0;
    static char[][] arr;
    static boolean[][] visited;
    static boolean[] check = new boolean[26]; // 알파벳 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        visited = new boolean[r][c];
        visited[0][0] = true;
        check[arr[0][0] - 65] = true;

        dfs(0, 0, 1);

        System.out.println(answer);
    }

    static void dfs(int x, int y, int cnt) {
        if (answer < cnt) answer = cnt;
        if (answer == 26) return;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            if (visited[nx][ny] || check[arr[nx][ny] - 65]) continue;

            visited[nx][ny] = true;
            check[arr[nx][ny] - 65] = true;
            dfs(nx, ny, cnt + 1);
            visited[nx][ny] = false;
            check[arr[nx][ny] - 65] = false;
        }

    }
}
