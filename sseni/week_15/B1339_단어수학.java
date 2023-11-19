package com.example.algorithm.study.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// abc = 100a + 10b + c
// 처음에는 그대로 저장했다가
// 예전에 풀었던 문제에서 reverse 했던 게 생각났다
public class B1339_단어수학 {
    static int n;
    static String[] strArray;
    static HashMap<Character, Integer> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    static int solution() {
        int answer = 0;

        int maxIdx = strArray[0].length() - 1;
        for (int i = maxIdx; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if(strArray[j].length() <= i) continue;

                char c = strArray[j].charAt(i);
                if(!hm.containsKey(c)) hm.put(c, (int) Math.pow(10, i));
                else hm.put(c, hm.get(c) + (int) Math.pow(10, i));
            }
        }

        List<Integer> list = new ArrayList<>();
        Iterator<Character> iter = hm.keySet().iterator();
        while (iter.hasNext()) list.add(hm.get(iter.next()));
        Collections.sort(list, (a, b) -> b -  a);

        int num = 9;
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i) * num--;
        }

        return answer;
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        strArray = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(br.readLine());
            strArray[i] = sb.reverse().toString();
        }

        Arrays.sort(strArray, (s1, s2) -> s2.length() - s1.length());
    }
}
