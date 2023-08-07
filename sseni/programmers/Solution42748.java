package com.example.javaproject3.psstudy;

import java.lang.reflect.Array;
import java.util.*;

public class Solution42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++)  // commands 길이 만큼 반복
            answer[i] = cutArray(array, commands[i]); // answer에 해당 command 에 대한 연산을 적용했을 때의 결과를 담아줌
        return answer;
    }

    public int cutArray(int[] array, int[] command) {  // 배열 잘라서 k 번째 있는 수를 리턴해주는 메소드
//        List<Integer> list = new ArrayList<>();
//        for (int i = command[0] - 1; i < command[1]; i++)
//            list.add(array[i]);
//        Collections.sort(list);
        int[] arr = Arrays.copyOfRange(array, command[0] - 1, command[1]);  // array 배열을 원하는 범위만큼만 복사하여 arr 에 저장
        Arrays.sort(arr);  // arr 정렬
        return arr[command[2] - 1];  // 배열에서 k 번째 수 리턴
    }

    public static void main(String[] args) {
        Solution42748 solution42748 = new Solution42748();
        System.out.println(Arrays.toString(solution42748.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }
}
