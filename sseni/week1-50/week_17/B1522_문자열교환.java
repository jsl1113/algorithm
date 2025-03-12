package com.example.algorithm.study.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// a 뭉쳐놓기, a 길이(윈도우) 만큼씩 검사해서 최솟값 갱신
// ex. ababab = a가 3개
// 0 aba = b 1개 교환
// 1 bab = b 2개 교환
// 결론: b가 한 개? a는 총 3개니까 나머지 한 개랑 b랑 교환하면 된다. -> aaabbb
public class B1522_문자열교환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int a = 0;
        for (char c : s.toCharArray()) {
            if(c == 'a') a++;
        }

        int answer = 1001;
        for (int i = 0; i < s.length(); i++) {
            answer = Math.min(answer, countB(s, 'b', i, i + a));
        }

        System.out.println(answer);
    }

    static int countB(String s, char c, int start, int end) {
        int b = 0;
        for (int i = start; i < end; i++) {
            if (s.charAt(i % s.length()) == c) {
                b++;
            }
        }
        return b;
    }
}
