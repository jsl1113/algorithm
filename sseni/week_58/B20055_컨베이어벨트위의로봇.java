package com.example.algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20055_컨베이어벨트위의로봇 {
    static int n, k, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[2 * n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] robots = new boolean[n];
        int step = 1;
        while (true) {
            int last = arr[arr.length - 1];
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = last;

            for (int i = n - 1; i > 0; i--) {
                robots[i] = robots[i - 1];
            }
            robots[0] = false;
            robots[n - 1] = false;

            for (int i = n - 2; i >= 0; i--) {
                if (robots[i] && !robots[i + 1] && arr[i + 1] > 0) {
                    robots[i] = false;
                    robots[i + 1] = true;
                    arr[i + 1]--;
                }
            }
            robots[n - 1] = false;

            if (arr[0] > 0) {
                robots[0] = true;
                arr[0]--;
            }

            int cnt = 0;
            for (int durability : arr) {
                if (durability == 0) {
                    cnt++;
                }
            }
            if (cnt >= k) break;
            step++;
        }

        System.out.println(step);
    }
}
