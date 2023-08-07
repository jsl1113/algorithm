package com.example.javaproject3.psstudy;

public class Solution68645 {
    public int[] solution(int n) {
        // 1. 최대 숫자 MaxNum 구하기
        int maxNum = 0;
        for (int i = 1; i <= n; i++)
            maxNum += i;

        // 2. num: 배열에 넣을 수, x, y: 배열 안 자리 탐색할 좌표값 변수 선언
        int[] answer = new int[maxNum];
        int[][] arr = new int[n + 1][n + 1];
        int num = 1, x = 0, y = 0;
        arr[0][0] = 1;

        // 3. 배열 원소 값 탐색하여 숫자 채우기
        while (true) {
            if (num == maxNum) break;  // maxNum 까지 배열에 다 채웠으면

            // 배열 아래로 채우기
            while (y + 1 < n) {
                if (arr[y + 1][x] != 0) break;
                arr[++y][x] = ++num;
            }

            // 배열 옆으로 채우기
            while (x + 1 < n) {
                if (arr[y][x + 1] != 0) break;
                arr[y][++x] = ++num;
            }

            // 배열 대각선으로 채우기
            while (y - 1 > 0 && x - 1 > 0) {
                if (arr[y - 1][x - 1] != 0) break;
                arr[--y][--x] = ++num;
            }
        }

        // 4. 첫 행부터 마지막 행까지 순서대로 합친 배열 생성
        int idx = 0; // 행 개수대로 index 처리할 변수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx] = arr[i][j];
                idx++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution68645 s = new Solution68645();
        int[] arr = s.solution(6);

        for (int a : arr) {
            System.out.printf("%d ", a);
        }
    }
}
