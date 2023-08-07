package com.example.javaproject3.psstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution42840 {
    // 1,2,3번 수포자가 찍는 방식 규칙 저장
    int[] arr1 = new int[]{1, 2, 3, 4, 5};
    int[] arr2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    int[] arr3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int[] cnt = new int[3]; // 1,2,3번 수포자의 맞은 문제를 계산하는 배열 선언
        for (int i = 0; i < answers.length; i++) { // 문제 개수 만큼 반복하여 맞은 문제 계산
            // 문제 답과 찍은 답이 같다면 카운트
            cnt[0] += answers[i] == arr1[i % arr1.length] ? 1 : 0;
            cnt[1] += answers[i] == arr2[i % arr2.length] ? 1 : 0;
            cnt[2] += answers[i] == arr3[i % arr3.length] ? 1 : 0;
        }

        int maxNum = Arrays.stream(cnt).max().getAsInt(); // 1,2,3 번 중 제일 많이 맞춘 값을 저장
        List<Integer> list = new ArrayList<>(); // 가장 높은 점수를 받은 사람을 저장하기 위한 리스트
        for (int i = 0; i < 3; i++) {  // 리스트에 max 값과 비교하여 같을 때 사람 번호를 add
            if (maxNum == cnt[i]) {
                list.add(i + 1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();  // list 를 int형 배열로 변환하여 리턴
    }

    public static void main(String[] args) {
        Solution42840 solution42840 = new Solution42840();
        solution42840.solution(new int[]{1, 2, 3, 4, 5});
    }
}
