package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 분할정복
public class B2630_색종이만들기 {
    static int n, arr[][], answer[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = new int[2];
        func(0, 0, n);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    static void func(int x, int y, int size) {
        int check = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (check == 0 && arr[i][j] == 1) check = 2;
                else if (check == 1 && arr[i][j] == 0) check = 2;

                if (check == 2) {
                    func(x, y, size / 2);
                    func(x, y + size / 2, size / 2);
                    func(x + size / 2, y, size / 2);
                    func(x + size / 2, y + size / 2, size / 2);
                    return;
                }
            }
        }

        if (check == 0) answer[0]++;
        else answer[1]++;
    }
}
