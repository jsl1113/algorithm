package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// flag1 = 회문, flag2 = 유사회문
public class B17609_회문 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String s = br.readLine();

            int left = 0, right = s.length() - 1;
            boolean flag1 = true, flag2 = false;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    flag1 = false;
                    if (check(s, left + 1, right) || check(s, left, right - 1)) flag2 = true;
                    break;
                }
                left++; right--;
            }

            if (flag1) sb.append(0);
            else if (flag2) sb.append(1);
            else sb.append(2);

            sb.append("\n");
        }

        System.out.print(sb);
    }

    static boolean check(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
