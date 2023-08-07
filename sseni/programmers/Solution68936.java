package com.example.javaproject3.psstudy;

import java.util.Arrays;

public class Solution68936 {
    static int zero = 0;  // 값이 0 일 때의 카운트 변수
    static int one = 0; // 값이 1 일 때의 카운트 변수
    public int[] solution(int[][] arr) {
        quad(arr, arr.length, 0, 0); // 쿼드 압축 메소드 호출
        return new int[]{zero, one};  // 메소드 실행 후 계산된 카운트 변수 리턴
    }

    public void quad(int[][] arr, int n, int x, int y) {
        // 분할된 구역이 각각 0과 1로 이루어져 있는지 검사할 boolean 변수 선언
        boolean isZero = true;
        boolean isOne = true;

        // 분할된 구역 계산하기
        // 모두 0일 때 : isZero 는 true, isOne 은 false가 됨
        // 0 과 1 이 있을 때 : isZero, isOne 모두 false 가 됨, 더 작게 분할해서 계산해야 한다는 의미
        for (int j = x; j < x + n; j++) {
            for (int i = y; i < y + n; i++) {
                if (arr[i][j] == 1) isZero = false;
                else if (arr[i][j] == 0) isOne = false;
            }
        }

        if (isZero) {  // 분할된 구역이 모두 0 일 때
            zero++; // 0 카운트 후, 리턴
            return;
        }
        if (isOne) { // 분할된 구역이 모두 1 일 때
            one++;  // 1 카운트 후, 리턴
            return;
        }

        quad(arr, n / 2, x, y);  // n/2 크기로 분할하여 왼쪽 위 위치 탐색
        quad(arr, n / 2, x + n / 2, y);  // n/2 크기로 분할하여 오른쪽 위 위치 탐색
        quad(arr, n / 2, x, y + n / 2); // n/2 크기로 분할하여 왼쪽 아래 위치 탐색
        quad(arr, n / 2, x + n / 2, y + n / 2); // n/2 크기로 분할하여 오른쪽 아래 위치 탐색
    }

    public static void main(String[] args) {
        Solution68936 solution68936 = new Solution68936();
        System.out.println(Arrays.toString(solution68936.solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
    }
}
