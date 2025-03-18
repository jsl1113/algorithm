package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 앞자리는 2,3,5,7만 올 수 있다
// 중간에는 1과 9도 올 수 있으니까, 1부터 2씩 늘려가며 dfs
public class B2023_신기한소수 {
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        System.out.println(sb);
    }

    static void dfs(int num, int cnt) {
        if (cnt == n) {
            sb.append(num).append("\n");
            return;
        }

        for (int i = 1; i < 10; i += 2) {
            if (isPrime(num * 10 + i)) {
                dfs(num * 10 + i, cnt + 1);
            }
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
