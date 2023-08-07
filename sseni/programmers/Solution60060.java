package com.example.javaproject3.psstudy;

import java.util.Arrays;

public class Solution60060 {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = wordCount(words, queries[i]);
        }
        return answer;
    }

    public int wordCount(String[] words, String query){
        String compareStr = ""; // 와일드카드 제외 문자열
        boolean location = false;  // 와일드카드의 위치가 앞에 위치해 있는지

        char tmp = query.charAt(0);  // 쿼리의 첫 번째 단어
        if(tmp == '?'){ // 와일드 카드 문자로 시작하면
            location = true;
        } else compareStr = Character.toString(tmp);

        for (int j = 1; j < query.length(); j++) {  // 와일드 카드 제외한 문자열 계산
            tmp = query.charAt(j);
            if(tmp != '?')
                compareStr += Character.toString(tmp);
        }

        int answer = 0;
        for(int j=0; j<words.length; j++){
            if(words[j].length() != query.length()) continue;

            if(location) {  // 와일드카드가 접두사일 때
                if(words[j].substring((query.length() - compareStr.length()), words[j].length()).equals(compareStr)) answer++;
            } else {  // 접미사일 때
                if(words[j].substring(0, compareStr.length()).equals(compareStr)) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution60060().solution(
                new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"fro??", "????o", "fr???", "fro???", "pro?"}))
        );
    }
}
