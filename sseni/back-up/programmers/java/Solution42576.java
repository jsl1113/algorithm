package com.example.javaproject3.psstudy;

import java.util.Arrays;

public class Solution42576 {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant); Arrays.sort(completion); // 참가자 배열과 완주하지 못한 선수 배열 정렬

        for (int i = 0; i < completion.length; i++) {  // completion 배열 요소마다
            if (!(participant[i].equals(completion[i]))) // participant 배열 요소와 같지 않으면
                return participant[i]; // 그때의 요소는 완주하지 못한 선수 이므로, 리턴
        }
        return participant[participant.length - 1];
    }

    public static void main(String[] args) {
        Solution42576 solution42576 = new Solution42576();
        solution42576.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
    }
}
