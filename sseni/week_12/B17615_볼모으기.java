package com.example.algorithm.study.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 앞에서부터, 빨강색 옮기기, 파란색 옮기기 해서 최솟값
// 뒤에서부터, 빨강색 옮기기, 파란색 옮기기 해서 최솟값
// 네 가지 경우의 수의 최솟값이 답이다.
public class B17615_볼모으기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int answer = Math.min(movebBack(str, str.charAt(n - 1)), moveFront(str, str.charAt(0)));
        System.out.println(answer);
    }

    static int movebBack(String str, char c) {
        int r = 0,  b = 0;
        boolean flag = false;
        for (int i = str.length() - 2; i >= 0; i--) {
            if(c == str.charAt(i) && !flag) continue;
            if(str.charAt(i) == 'R') r++;
            else b++;
            flag = true;
        }
        return Math.min(r, b);
    }

    static int moveFront(String str, char c) {
        int r = 0, b = 0;
        boolean flag = false;
        for (int i = 1; i < str.length(); i++) {
            if(c == str.charAt(i) && !flag) continue;
            if(str.charAt(i) == 'R') r++;
            else b++;
            flag = true;
        }
        return Math.min(r, b);
    }
}
