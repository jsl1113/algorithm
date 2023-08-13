package com.example.javaproject3.psstudy;

import java.util.Arrays;

public class Solution1843 {
    int dpMin[][] ,dpMax[][];

    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;
        dpMin = new int[n + 1][n + 1];
        dpMax = new int[n + 1][n + 1];
        char operArr[] = new char[n];
        int numArr[] = new int[n + 1];

        int arrNum = 0, operNum = 0;
        for (int i = 0; i < arr.length; i++) {  // 연산자와 피연산자 배열로 나눠줌
            if (i % 2 == 0) numArr[++arrNum] = Integer.parseInt(arr[i]);
            else operArr[++operNum] = arr[i].charAt(0);
        }

        for (int i = 1; i <= n; i++) {  // DP 배열 초기화
            Arrays.fill(dpMax[i], Integer.MIN_VALUE);
            Arrays.fill(dpMin[i], Integer.MAX_VALUE);
            dpMax[i][i] = numArr[i];
            dpMin[i][i] = numArr[i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j + i <= n; j++) {
                for (int k = j; k < (j + i); k++) {
                    if(operArr[k] == '+'){  // + 일 때,
                        dpMax[j][j + i] = Math.max(dpMax[j][k] + dpMax[k + 1][j + i], dpMax[j][j + i]); // 최댓값은 A와 B가 모두 최댓값
                        dpMin[j][j + i] = Math.min(dpMin[j][k] + dpMin[k + 1][j + i], dpMin[j][j + i]); // 최솟값은 A와 B가 모두 최솟값
                    } else { // - 일 때,
                        dpMax[j][j + i] = Math.max(dpMax[j][k] - dpMin[k + 1][j + i], dpMax[j][j + i]); // 최댓값은 A는 최댓값, B는 최솟값
                        dpMin[j][j + i] = Math.min(dpMin[j][k] - dpMax[k + 1][j + i], dpMin[j][j + i]); // 최솟값은 A는 최솟값, B는 최솟값
                    }
                }
            }
        }

        return dpMax[1][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1843().solution(new String[]{"1", "-", "3", "+", "5", "-", "8"}));
//        System.out.println(new Solution1843().solution(new String[]{"5", "-", "3", "+", "1", "+", "2", "-", "4"}));
    }
}
