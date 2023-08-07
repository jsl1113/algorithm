package com.example.javaproject3.psstudy;

import java.util.Arrays;

public class Solution42884 {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1])); // 종료 위치를 기준으로 오름차순 정렬
        for(int i=0; i < routes.length; i++)
            System.out.print(Arrays.toString(routes[i]));

        int camera = -30_001; // 진입/진출 지점의 최솟값
        for(int[] route : routes){
            if(camera >= route[0]) continue; // 카메라 위치보다 작거나 같으면, 설치하지 않아도 됨
            camera = route[1]; // 카메라 위치 갱신
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution42884().solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }
}
