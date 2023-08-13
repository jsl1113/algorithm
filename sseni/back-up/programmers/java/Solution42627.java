package com.example.javaproject3.psstudy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution42627 {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // 실행 시간이 짧은 순대로
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // 시작 시간이 짧은 순으로

        /*
        answer : 요청부터 종료까지 걸린 시간
        idx : 작업 배열 index
        time : 작업 처리 완료 시간
        finished : 처리 완료한 작업 개수
        */
        int answer = 0, idx = 0, time = 0, finished = 0;
        // 작업 시작은 시작 시간이 짧은 순대로 시작,
        // 대기하고 있는 스케줄 중 끝나는 시간이 짧은 스케줄 먼저 처리
        while (finished != jobs.length){
            while (idx < jobs.length && jobs[idx][0] <= time)
                q.add(jobs[idx++]); // 이전 작업 처리 중 요청된 작업 add

            if(q.isEmpty())  // 이전 작업 처리 중에 요청된 작업이 없는 경우
                time = jobs[idx][0]; // 다음 작업 요청 시점으로 갱신
            else {
                int[] work = q.poll();
                answer += time + (work[1] - work[0]); // 작업 요청부터 종료까지 걸린 시간 추가
                 time += work[1];  // 작업 처리 완료 시간 갱신
                finished++;
            }
        }
        return answer / jobs.length; // 평균 리턴
    }

    public static void main(String[] args) {
        int answer = new Solution42627().solution(new int[][]{{0,3},{1,9},{2,6}});
        System.out.println(answer);
    }
}
