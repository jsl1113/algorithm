package com.example.algorithm.study;
import java.io.*;
import java.util.StringTokenizer;
/*
A를 B번 곱한 수 -> 지수 법칙, 모듈로 곱셈 성질 이용
지수 법칙: a^m x a^n = a^(m+n)
모듈로 곱셈: (a * b) mod c = (a mod c * b mod c) mod c

ex. 10 ^ 11 % 12
= (10 ^ 5) * (10 ^ 6) % 12
= ((10 ^ 5) % 12 * (10 ^ 6) % 12) % 12
*/
public class B1629_곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long answer = func(a, b, c);
        System.out.println(answer);
    }

    static long func(long a, long b, long c) {
        if(b == 1) return a % c;

        long n = func(a, b / 2, c);

        if(b% 2 != 0) return n * n % c * a % c;
        else return n * n % c;
    }
}
