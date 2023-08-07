package com.example.javaproject3.psstudy;

import java.util.Arrays;
import java.util.HashMap;

public class Solution64063 {
    HashMap<Long, Long> map = new HashMap<>();  // <방 번호, 방 번호의 부모 노드> 를 HashMap으로 저장

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for(int i=0; i < room_number.length; i++)
            answer[i] = findRoom(room_number[i]); // 원하는 방 번호에 따라 배정되는 방 번호를 리턴하는 메소드 호출

        return answer;
    }

    long findRoom(long num){
        if(!map.containsKey(num)){ // 해당 방이 정해지지 않았다면
            map.put(num, num+1); // 빈 방이므로, 다음 방을 부모 노드로 설정 후
            return num; // 방 번호 리턴
        }
        long empty = findRoom(map.get(num)); //  원하는 방의 부모 노드가 빈 방인지 재귀 호출로 탐색
        map.put(num, map.get(empty)); // num 의 부모 노드를 empty의 부모 노드로 설정해주고
        return empty; // 빈 방 리턴
    }

//    long findEmptyRoom(boolean[] visit, long customer, long room){
//        if(!map.containsKey(customer) && !visit[(int) room-1]) {
//            map.put(customer, room);
//            visit[(int) room-1] = true;
//            return room;
//        }
//        if(!visit[(int) room-1]) {
//            return room;
//        }
//        return findEmptyRoom(visit, customer, room+1);
//    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution64063().solution(10, new long[]{1,3,4,1,3,1})));
    }
}
