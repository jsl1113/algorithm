package com.example.javaproject3.psstudy;

import java.lang.reflect.Array;
import java.util.*;

public class Solution42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>(); // 작업일 저장 큐, 앞 작업이 끝나야 뒤 작업도 끝나기 때문에 큐 이용
        for (int i = 0; i < progresses.length; i++) {
            int date = (100 - progresses[i]) % speeds[i] == 0 ?
                    (100 - progresses[i]) / speeds[i] :
                    (100 - progresses[i]) / speeds[i] + 1;  // 필요한 작업일 계산
            System.out.println(q.peek() + " " + date);
            // q.size() -> 해당 일자에 배포 가능한 작업 개수
            if(!q.isEmpty() && q.peek() < date) { // 큐가 비어있지 않고 큐의 top 이 작업일보다 작으면
                result.add(q.size()); // 이전에 큐에 추가한 작업 개수를 리스트에 추가
                q.clear();
            }
            q.add(date);  // 작업일 추가
        }
        result.add(q.size()); // 큐에 남아있는 마지막 작업 개수 리스트에 추가

        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++)
            answer[i] = result.get(i);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution42586().solution(new int[]{93,30,55}, new int[]{1,30,5})));
    }
}
