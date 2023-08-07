package com.example.javaproject3.psstudy;

import java.util.Arrays;

public class Solution42842 {
    public int[] solution(int brown, int yellow) {
        int y = 3;  // 카펫 전체 세로 길이 (노란색이 최소 길이가 1이므로 갈색은 최소 길이가 3)
        int x = (brown + yellow) / y;  //  카펫 전체 가로 길이 (최대 길이를 y로 나눈 값)

        while (x >= y) {  // 가로가 세로보다 길거나 같다는 조건 하에 완전 탐색
            if ((x - 2) * (y - 2) == yellow) break;  //  노란색 가로와 세로의 곱이 노란색 칸의 개수와 같을 때 break
            else x = (brown + yellow) / ++y;  // y를 늘려주고 x 는 최대 길이를 y로 나눈 값으로 저장
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        Solution42842 solution42842 = new Solution42842();
        System.out.println(Arrays.toString(solution42842.solution(10, 2)));
        System.out.println(Arrays.toString(solution42842.solution(8, 1)));
        System.out.println(Arrays.toString(solution42842.solution(24, 24)));
    }
}
