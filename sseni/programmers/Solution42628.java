package com.example.javaproject3.psstudy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution42628 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder()); // 최댓값 우선 순위 큐
        PriorityQueue<Integer> pqMin = new PriorityQueue<>(); // 최솟값 우선 순위 큐

        for(String operation : operations){
            String[] strArray = operation.split(" ");
            char op = strArray[0].charAt(0); // 명령어
            int num = Integer.parseInt(strArray[1]); // 데이터
            switch (op){
                case 'I' -> { // 삽입
                    pqMin.add(num);
                    pqMax.add(num);
                }
                case 'D' -> { // 삭제
                    if(pqMax.isEmpty()) break; // 비어있을 시, 해당 연산 무시
                    if(num == 1)  pqMin.remove(pqMax.poll()); // 최댓값 삭제) 최댓값 큐에서 poll 연산 후, poll 한 값을 최솟값 큐에서 찾아 삭제
                    if(num == -1) pqMax.remove(pqMin.poll()); // 최솟값 삭제) 최솟값 큐에서 poll 연산 후, poll 한 값을 최댓값 큐에서 찾아 삭제
                }
            }
        }
        if(pqMax.isEmpty()) return new int[]{0, 0};
        return new int[]{pqMax.peek(), pqMin.peek()}; // 최댓값, 최솟값 큐에서 각각 최상단 값 반환
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution42628().solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }
}
