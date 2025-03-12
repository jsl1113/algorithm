package com.example.algorithm.study.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. 타자 경우의 수 백트래킹
// 2. 게임 진행 후 최대 점수 갱신
// 경우의 수를 구하긴 했는데, 게임 진행하는 알고리즘을 생각하지 못했다 ...
// 근데 경우의 수도 많고, 게임 진행하는 로직에도 시간 소요가 클 거 같은데 라고 생각함
public class B17281_야구공 {
    static int n, answer = -1;
    static int[][] arr;
    static boolean[] visited = new boolean[10];
    static int[] player = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][10];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[4] = true;
        player[4] = 1;  // 4번은 1번 타자
        dfs(2);
        System.out.println(answer);
    }

    public static void dfs(int cnt) {
        if (cnt == 10) {
            answer = Math.max(answer, game());
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                player[i] = cnt;
                dfs(cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static int game() {
        int start = 1, score = 0;

        for (int i = 0; i < n; i++) {
            int[] point = {0, 0, 0, 0, 0};

            while (point[0] < 3) {
                for (int j = 0; j < arr[i][player[start]]; j++) {
                    point[4] += point[3];
                    point[3] = point[2];
                    point[2] = point[1];
                    point[1] = 0;
                }
                point[arr[i][player[start]]]++;

                if (start == 9) start = 1;
                else start++;
            }
            score += point[4];
        }

        return score;
    }
}
