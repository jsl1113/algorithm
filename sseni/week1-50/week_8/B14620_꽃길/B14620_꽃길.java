package com.example.algorithm.study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 브루트포스 문제이기 때문에 처음에 꽃을 심을 수 있는 좌표 케이스를 모두 찾고,
// 최소 비용을 갱신하는 식의 방법을 떠올렸는데,
// 올 수 있는 꽃의 좌표인지 검사하는 조건을 어떻게 체크할 지, 어떤 조건이 있는지
// 생각하는 데 시간이 꽤 걸렸던 것 같다. 그래도 한 큐에 성공을 해서 뿌듯했다.
public class B14620 {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] strArray = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(strArray[j]);
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n * n; i++) {
            for (int j = i; j < n * n; j++) {
                for (int k = j; k < n * n; k++) {
                    if (isBeFlower(i, j) && isBeFlower(j, k) && isBeFlower(k, i)) {
//                        System.out.println(i + " " + j + " " + k);
                        minCost = Math.min(calCost(i) + calCost(j) + calCost(k), minCost);
                    }
                }
            }
        }

        System.out.println(minCost);
    }

    private static int calCost(int num){
        int i = num / n;
        int j = num % n;
        return arr[i][j] + arr[i - 1][j] + arr[i][j - 1] + arr[i + 1][j] + arr[i][j + 1];
    }

    private static boolean isBeFlower(int i, int j) {
        // 양 끝에는 심을 수 없기 때문에 가장자리라면 false 반환
        if (i / n == 0 || i / n == n - 1) return false;
        if (j / n == 0 || j / n == n - 1) return false;

        if (i % n == 0 || i % n == n - 1) return false;
        if (j % n == 0 || j % n == n - 1) return false;

        // 꽃 좌표 간 위치가 두 줄 차이일 때 && 같은 열에 있는 경우 false 반환
        if ((Math.abs(j / n - i / n) == 2) && (i % n == j % n)) return false;

        // 꽃 좌표 간 위치가 한 줄 차이일 때 && 1칸 간격 이하에 있는 경우 false 반환
        else if ((Math.abs(j / n - i / n) == 1) && (Math.abs(i % n - j % n) < 2)) return false;

        // 같은 줄에 위치해있을 때 && 2칸 간격 이하에 있는 경우 false 반환
        else if ((i / n == j / n) && (Math.abs(i % n - j % n) < 3)) return false;

        return true;
    }
}
