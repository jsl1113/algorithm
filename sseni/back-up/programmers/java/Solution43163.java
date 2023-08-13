package com.example.javaproject3.psstudy;

public class Solution43163 {
    int answer = 0;
    boolean[] visit;

    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        dfs(begin, target, 0, words); // 재귀 호출
        return answer;
    }

    public void dfs(String begin, String target, int cnt, String[] words) {
        if (begin.equals(target)) {  // begin 단어와 target 단어가 같아지면
            answer = Math.min(answer, cnt); // 변환 과정 개수 더 작은 값 저장
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visit[i] && check(begin, words[i])) {
                visit[i] = true;  // 찾은 단어 true 처리
                dfs(words[i], target, cnt + 1, words); // 단어를 변경할 때cnt 를 증가시키며 재귀 호출
                visit[i] = false; // 모든 경우의 수를 위해 false 처리
            }
        }
    }

    // 한 글자 제외하고 같은 단어를 체크하는 메소드
    public boolean check(String begin, String next) {
        int cnt = 0; // 다른 문자 개수 카운트
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != next.charAt(i))
                cnt++;
        }
        return cnt == 1 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution43163().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
}
