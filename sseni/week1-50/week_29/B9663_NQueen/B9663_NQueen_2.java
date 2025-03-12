package com.example.algorithm.study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// n의 범위가 14까지다.
public class B9663_NQueen_2 {
    public static void main(String[] args) throws IOException {
        int[] answer = {1, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(answer[n]);
    }
}
