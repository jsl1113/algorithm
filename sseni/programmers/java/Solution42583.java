package com.example.javaproject3.psstudy;

import java.util.LinkedList;
import java.util.Queue;

public class Solution42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 경과 시간
        Queue<Integer> queue = new LinkedList<>(); // 지나가는 트럭 무게 저장할 큐 (앞의 트럭이 나가야 뒤 트럭도 나갈 수 있어서 )
        int tmp = 0, idx = 0; // tmp : 트럭 무게 총합, idx : 트럭 무게 참조할 index 변수

        // 마지막 트럭이 다리에 올라갈 때, 반복문 종료
        while (idx < truck_weights.length){
            if(queue.size() == bridge_length)   // 다리에 트럭이 들어갈 수 없는 경우, 건너갈 트럭의 무게를 현재 다리의 트럭 무게 총합에서 빼줌
                tmp -= queue.poll();
            else if(tmp + truck_weights[idx] > weight) { // 현재 트럭 무게 총합과 올라갈 트럭의 무게의 합이 weight 보다 클 경우
                queue.offer(0);  // 다리가 버틸 수 있는 무게를 고려하기 위해 큐에 0을 넣어서 자리를 채워줌
                answer++;
            } else { // 트럭이 올라가는 경우
                queue.offer(truck_weights[idx]);
                tmp += truck_weights[idx++];
                answer++;
            }
        }
        // 마지막 트럭이 큐에 추가되고 큐는 꽉 찬 채 반복이 종료되므로, 마지막 트럭이 다리에서 나갈 시간까지 더해줌
        return answer + bridge_length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution42583().solution(2, 10, new int[]{7,4,5,6}));
    }
}
