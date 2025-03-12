package com.example.algorithm.study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 처음에는 zbxz 가 abca 로 바뀌는 것 조차 이해가 잘 안 됐었다.
// 하나의 알파벳으로 바꿨다면 다른 알파벳은 해당 알파벳으로 바꿀 수 없다?
// 약간 각각의 단어에 겹치는? 단어의 위치라고 해야할까 그걸 같은 걸 찾는다? 부터 생각 시작
// a 부터 시작하는 건 모든 단어를 같은 단어로 만들기 위한 수단..? 이라고 할까나
public class B1411 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strArray = new String[n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            strArray[i] = s;

            StringBuilder tmp = new StringBuilder();
            Map<Character, Character> map = new HashMap<>();
            char c = 'a';
            for (int j = 0; j < s.length(); j++) {
                if (!map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), (char) (c));
                    c++;
                }
                tmp.append(map.get(s.charAt(j)));
            }

            strArray[i] = tmp.toString();
            System.out.println(map);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (strArray[i].equals(strArray[j])) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
