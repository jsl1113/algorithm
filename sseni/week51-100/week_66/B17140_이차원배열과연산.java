package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B17140_이차원배열과연산 {
    static int[][] arr = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        int R = 3, C = 3;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int time = 0; time <= 100; time++) {
            if (arr[r][c] == k) {
                System.out.println(time);
                return;
            }

            if (R >= C) C = operate(R, C, true); // R 연산
            else R = operate(C, R, false); // C 연산
        }

        System.out.println(-1);
    }

    static int operate(int max1, int max2, boolean check) {
        int result = 0;

        for (int i = 0; i < max1; i++) {
            // 각 cnt, num 카운트
            Map<Integer, Integer> hm = new HashMap<>();
            for (int j = 0; j < max2; j++) {
                int val = check ? arr[i][j] : arr[j][i];
                if (val > 0) hm.put(val, hm.getOrDefault(val, 0) + 1);
                if (check) arr[i][j] = 0;
                else arr[j][i] = 0;
            }

            List<Pair> pairs = new ArrayList<>();
            hm.forEach((num, cnt) -> pairs.add(new Pair(cnt, num)));
            pairs.sort(Comparator.naturalOrder());

            int idx = 0;
            for (Pair pair : pairs) {
                if (idx >= 100) break;
                if (check) { // R 연산
                    arr[i][idx++] = pair.num;
                    arr[i][idx++] = pair.cnt;
                } else { // C 연산
                    arr[idx++][i] = pair.num;
                    arr[idx++][i] = pair.cnt;
                }
            }
            result = Math.max(result, idx);
        }

        return result;
    }

    static class Pair implements Comparable<Pair> {
        int cnt, num;

        Pair(int cnt, int num) {
            this.cnt = cnt;
            this.num = num;
        }

        public int compareTo(Pair o) {
            return this.cnt == o.cnt ? Integer.compare(this.num, o.num) : Integer.compare(this.cnt, o.cnt);
        }
    }
}
