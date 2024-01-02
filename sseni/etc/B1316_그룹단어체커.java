package com.example.algorithm.study.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B1316_그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> hm = new HashMap<>();
            String str = br.readLine();
            char tmp = str.charAt(0);
            boolean flag = true;
            for (char c : str.toCharArray()) {
                if(!hm.containsKey(c)){
                    hm.put(c, 1);
                    tmp = c;
                } else {
                    if (c == tmp) hm.put(c, hm.get(c) + 1);
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) answer++;
        }
        System.out.println(answer);
    }
}
