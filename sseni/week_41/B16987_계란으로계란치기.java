package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16987_계란으로계란치기 {
    static int n, answer;
    static Egg[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new Egg[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[i] = new Egg(num, weight);
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int cnt, int value) {
        if (cnt == n || value == n - 1) {
            answer = Math.max(answer, value);
            return;
        }

        if (arr[cnt].num <= 0) {
            dfs(cnt + 1, value);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i == cnt || arr[i].num <= 0) continue;

            if (arr[i].num > 0) {
                arr[cnt].num -= arr[i].weight;
                arr[i].num -= arr[cnt].weight;
                dfs(cnt + 1, value +
                        (arr[i].num <= 0 ? 1 : 0) +
                        (arr[cnt].num <= 0 ? 1 : 0));
                arr[cnt].num += arr[i].weight;
                arr[i].num += arr[cnt].weight;
            }
        }
    }

    static class Egg {
        int num, weight;

        Egg(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
}
