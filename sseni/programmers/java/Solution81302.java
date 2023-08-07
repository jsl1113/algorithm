package com.example.javaproject3.psstudy;

import java.util.*;

public class Solution81302 {
    int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};   // 거리두기 탐색 좌표
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        // 기본값을 1로 설정, 거리두기를 지키지 않을 경우 0으로
        Arrays.fill(answer, 1);

        int idx = 0;
        for(String[] place : places){  // 대기실마다
            char[][] arr = new char[5][5];
            for (int i = 0; i < 5; i++)
                arr[i] = place[i].toCharArray();

            // 한 대기실 기준, 거리두기 확인하기
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    int cntPeople = 0;  // 사람 한 명 확인할 때마다 초기화
                    if (arr[i][j] == 'X') continue;  // 파티션일 때
                    if (arr[i][j] == 'P') cntPeople++; // 사람일 때

                    for (int k = 0; k < 4; k++) {  // 현재 위치 기준 상하좌우 탐색
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
                            continue;
                        // 현 위치 근처에 사람이 있다면
                        if (arr[nx][ny] == 'P') cntPeople++;
                    }
                    if (cntPeople >= 2) {  // 사람이 두 명 이상이면
                        answer[idx] = 0;
                        break;
                    }
                }
                // 이미 0으로 바꿨으면 더이상 탐색할 필요 x
                if(answer[idx] == 0) break;
            }
            idx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        Solution81302 solution81302 = new Solution81302();
        System.out.println(Arrays.toString(solution81302.solution(places)));
    }
}
