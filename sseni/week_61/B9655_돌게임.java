package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1 1 / 1 3 / 3 1 / 3 3
// 짝홀로 판단 가능 .. dp 라며 ..
public class B9655_돌게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Integer.parseInt(br.readLine()) % 2 != 0 ? "SK" : "CY");
    }
}
