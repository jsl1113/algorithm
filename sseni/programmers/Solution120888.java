package com.example.javaproject3.psstudy;

import java.util.*;

public class Solution120888 {
    public String solution(String my_string) {
        String answer = "";
        HashSet<Character> hs = new HashSet<>();
        for(char c : my_string.toCharArray()){  // char 형 배열로 변환하여 탐색
            if(!hs.contains(c)) { // 해당 요소가 hashset에 포함되어 있지 않으면 answer 에 더하고 hashset에 추가
                answer += c;
                hs.add(c);
            }
        }
        return answer;
    }

    public String solution_(String my_string) {
        String[] answer = my_string.split("");
        Set<String> set = new LinkedHashSet<String>(Arrays.asList(answer));
        return String.join("", set);
    }
}
