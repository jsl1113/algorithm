package com.example.javaproject3.psstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution12946 {
    List<int[]> arr = new ArrayList<>();  // 옮기는 과정 저장 리스트
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2); // 하노이의 탑 메소드 호출
        int[][] answer = new int[arr.size()][2]; // 옮기는 과정 리스트 개수만큼 배열 생성
        for(int i=0; i < arr.size(); i++) answer[i] = arr.get(i); // List to Array
        return answer;
    }

    public void hanoi(int n, int start, int end, int mid){
        if(n == 1) arr.add(new int[]{start, end});  // n이 1일 때 start, end 값을 list 에 저장
        else{
            hanoi(n-1, start, mid, end);  // 1. n-1 개의 원판을 start 에서 mid 로 옮김
            arr.add(new int[]{start, end}); // 2. 마지막 큰 원판을 옮긴 과정 저장
            hanoi(n-1, mid, end, start);  //  3. n-1 개의 원판을 mid 에서 end 로 옮김
        }
    }
    public static void main(String[] args) {
        Solution12946 solution12946 = new Solution12946();
        int[][] answer = solution12946.solution(3);
        for(int i=0; i < answer.length; i++){
            System.out.print(Arrays.toString(answer[i]));
        }
    }
}
