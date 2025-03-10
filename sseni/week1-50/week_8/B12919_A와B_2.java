package com.example.algorithm.study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 처음에는 a 추가, b추가 뒤집기 둘다 재귀 안에서 호출해서 시간 초과가 났다.
// 어떻게 선택적으로 하나만 호출할 수 있을까?
// -> t 를 검사하자 -> t 문자를 제거하면서 호출하면 되겠다 의 흐름
// baba - aba, bab - (ab), ba - a, (b) - return
public class B12919 {
    static boolean result = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        abab(s, t);
        System.out.println(result ? 1 : 0);
    }

    public static void abab(String s, String t) {
        if (s.length() == t.length()) {
            if(s.equals(t)) {
                result = true;
            }
            return;
        }

        if (t.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(t.substring(1));
            abab(s, sb.reverse().toString());
        }

        if (t.charAt(t.length() - 1) == 'A') {
            abab(s, t.substring(0, t.length() - 1));
        }
    }

    // s에 추가하면서 재귀 호출한 코드 (시간 초과)
    public static void ababa(String s, String t) {
        if (s.length() == t.length()) {
            if(s.equals(t)) {
                result = true;
            }
            return;
        }

        abab(s + "A", t);
        abab(new StringBuffer(s + "B").reverse().toString(), t);
    }
}
