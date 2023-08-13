package com.example.javaproject3.psstudy;

public class Solution12945 {
    public int solution(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++)  // 동적 계획법, 3부터 시작해서 n까지 반복
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;

        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution12945().solution(5));
    }
}
