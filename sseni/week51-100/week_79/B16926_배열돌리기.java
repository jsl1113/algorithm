package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 방향 문제들은 어렵진 않지만 귀찮고 헷갈려 ..
public class B16926_배열돌리기 {
    static int n, m, r;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layers = Math.min(n, m) / 2;
        for (int k = 0; k < r; k++) {
            for (int layer = 0; layer < layers; layer++) {
                rotateLayer(layer);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : arr) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    // 반시계 방향으로 한 칸 회전
    static void rotateLayer(int layer) {
        int top = layer;
        int left = layer;
        int bottom = n - 1 - layer;
        int right = m - 1 - layer;

        List<Integer> values = new ArrayList<>();
        for (int i = left; i < right; i++) values.add(arr[top][i]);
        for (int i = top; i < bottom; i++) values.add(arr[i][right]);
        for (int i = right; i > left; i--) values.add(arr[bottom][i]);
        for (int i = bottom; i > top; i--) values.add(arr[i][left]);

        Collections.rotate(values, -1);

        int idx = 0;
        for (int i = left; i < right; i++) arr[top][i] = values.get(idx++);
        for (int i = top; i < bottom; i++) arr[i][right] = values.get(idx++);
        for (int i = right; i > left; i--) arr[bottom][i] = values.get(idx++);
        for (int i = bottom; i > top; i--) arr[i][left] = values.get(idx++);
    }

}
