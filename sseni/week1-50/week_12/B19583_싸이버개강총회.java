package com.example.algorithm.study.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 1. 개총 한 시간 전부터 개총까지 채팅 닉네임 저장
// ( 1 : 입장, 2 : 퇴장으로 map에 저장 )
// 2. 개총 끝 ~ 스트리밍 끝 시간 동안 채팅 닉네임 확인 후 저장
public class B19583_싸이버개강총회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArray = br.readLine().split(" ");
        int start = Integer.parseInt(strArray[0].split(":")[0] + strArray[0].split(":")[1]);
        int end = Integer.parseInt(strArray[1].split(":")[0] + strArray[1].split(":")[1]);
        int streaming = Integer.parseInt(strArray[2].split(":")[0] + strArray[2].split(":")[1]);

        Map<String, Integer> map = new HashMap<>();
        while (true){
            String chat = br.readLine();
            if(chat == null || chat.length() == 0) break;
            String[] chatting = chat.split(" ");  // 시간 닉네임 순
            int time = Integer.parseInt(chatting[0].split(":")[0] + chatting[0].split(":")[1]);

            if(time <= start)
                map.put(chatting[1], 1);
            else if(time >= end && time <= streaming && map.get(chatting[1]) == 1)
                map.put(chatting[1], 2);
        }

        int cnt = 0;
        for (int v : map.values()) {
            cnt += (v == 2 ? 1 : 0);
        }
        System.out.println(cnt);
    }
}
