package com.example.algorithm.study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 처음에 예제 3 / 1 2 3 을 보고 전혀 이해하지 못했었다.
// 아무래도 합 크기를 비교하다 보니까 정렬은 떠올렸었다.
// 최대 길이 = 수열에서 가질 수 있는, 나타낼 수 있는 인덱스의 길이
public class B1548 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] strArray = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArray[i]);
        }

        System.out.println(solution(n, arr));
    }

    public static int solution(int n, int[] arr) {
        Arrays.sort(arr);
        int maxLength = Math.min(n, 2);

        for (int i = 0; i < n - 1; i++) { // 앞에서부터
            for (int j = n - 1; j >= 0; j--) { // 뒤에서부터
                if(i + 1 == j) break;  // 다음 수가 비교하는 수와 중복되지 않게

                // ex. arr가 [1,2,3,3,4,4,5] 이고, i = 2, j = 6 일 때(3,3,4,4,5) 부분 삼각 수열을 만족
                if (arr[i] + arr[i + 1] > arr[j]) {
                    maxLength = Math.max(maxLength, j - i + 1); // 6 - 2 + 1 = 5 개를 반환
                    break;
                }
            }
        }

        return maxLength;
    }
}
