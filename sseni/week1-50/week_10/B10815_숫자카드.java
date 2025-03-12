package com.example.algorithm.study.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 처음에 그냥 contains 쓰면 편하겠다.. 했지만
// 범위가 크다.. 이분탐색.. 가자.. 처음부터.
public class B10815_숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nArray = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .toArray();

        int m = Integer.parseInt(br.readLine());
        int[] mArray = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .toArray();

        Arrays.sort(nArray);

        boolean[] result = new boolean[m];
        for (int i = 0; i < m; i++) {
            int start = 0, end = n;

            while (start < end) {
                int mid = (start + end) / 2;

                if (mArray[i] == nArray[mid]) {
                    result[i] = true;
                    break;
                }
                else if(mArray[i] < nArray[mid]) end = mid;
                else if (mArray[i] > nArray[mid]) start = mid  + 1;
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.print((result[i] ? 1 : 0) + " ");
        }
    }
}
