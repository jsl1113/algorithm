package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 종유석과 석순을 각각 저장해서 졍렬 후 이탐
public class B3020_개똥벌레 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] up = new int[n / 2];
        int[] down = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            down[i] = Integer.parseInt(br.readLine());
            up[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(up);
        Arrays.sort(down);

        int[] answer = new int[0];
        answer[0] = n;
        answer[1] = 0;

        for (int i = 1; i <= h; i++) {
            int num = binarySearch(0, n / 2, i, down) +
                    binarySearch(0, n / 2, h - i + 1, up);

            if(answer[0] == num) {
                answer[1]++;
                continue;
            }

            if (answer[0] > num) {
                answer[0] = num;
                answer[1] = 1;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }

    static int binarySearch(int start, int end, int h, int[] arr) {
        while (start < end) {
            int mid = (start + end) / 2;

            if(arr[mid] >= h) end = mid;
            else start = mid + 1;
        }

        return arr.length - end;
    }
}
