package com.example.algorithm.study.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 처음에 max 값을 그냥 Arrays.stream(arr).max().getAsInt() 로 했다가
// 계속 47%에서 틀렸는데 getAsInt 가 문제 같다. (전체적으로 long형 이기 때문에)
// start랑 end 랑 계속 출력해보면서 +1 할지 안할지.. 출력은 -1할지 안할지.. 생각했던 거 같다.
public class B1654_랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        long end = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end = Math.max(arr[i], end);
        }
        end++;

        long start = 0;
        while (start < end) {
            long mid = (start + end) / 2;

            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += (arr[i] / mid);
            }

            if(sum >= n) start = mid + 1;
            else end = mid;
        }

        System.out.println(start - 1);
    }
}
