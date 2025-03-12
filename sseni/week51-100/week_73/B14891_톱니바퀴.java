package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14891_톱니바퀴 {
    static int k;
    static int[][] arr = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            func(num, d);
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i][0] == 1) {
                answer += (1 << i);
            }
        }

        System.out.println(answer);
    }

    static void func(int num, int d) {
        int[] dir = new int[4]; // 톱니바퀴 회전 유무 상태 확인
        dir[num] = d;

        // 왼쪽
        for (int i = num - 1; i >= 0; i--) {
            if (arr[i][2] != arr[i + 1][6]) dir[i] = -dir[i + 1];
            else break;
        }

        // 오른쪽
        for (int i = num + 1; i < 4; i++) {
            if(arr[i-1][2] != arr[i][6]) dir[i] = -dir[i - 1];
            else break;
        }

        // 회전 확인
        for (int i = 0; i < 4; i++) {
            if (dir[i] != 0) {
                rotate(i, dir[i]);
            }
        }
    }

    static void rotate(int num, int d) {
        if (d == 1) {
            int end = arr[num][7];
            System.arraycopy(arr[num], 0, arr[num], 1, 7);
            arr[num][0] = end;
        } else {
            int start = arr[num][0];
            System.arraycopy(arr[num], 1, arr[num], 0, 7);
            arr[num][7] = start;
        }
    }
}
