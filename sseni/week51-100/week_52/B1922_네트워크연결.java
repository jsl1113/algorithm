package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// MST 최소신장트리
// 1. 가중치를 오름차순으로 정렬
// 2. 사이클을 형성하지 않는 + 가장 낮은 가중치를 가진 간선을 선택
// 사이클 형성 판단 -> union-find
public class B1922_네트워크연결 {
    static int n, m;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        int[][] arr = new int[m][3];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(x -> x[2]));

        int answer = 0;
        for(int[] network : arr){
            if(union(network[0], network[1])){
                answer += network[2];
            }
        }

        System.out.println(answer);
    }

    static int find(int x) {
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    static boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            parents[x] = y;
            return true;
        } else return false;
    }
}
