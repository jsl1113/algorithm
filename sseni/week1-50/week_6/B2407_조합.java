package com.example.algorithm.study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 처음에 long 으로 해서 틀렸다. 틀린 케이스가 있겠다 싶어
// 100 50 을 조합 계산기로 돌린 값이랑 계산해보니 틀리더라.
// long 보다 더 큰 자료형을 생각했다. BigInteger는 알았는데 계산 방식은 찾아봤다.
public class B2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == m) {
            System.out.println(1);
            return;
        }

        m = Math.min(m, n - m);

        BigInteger result = BigInteger.valueOf(1);
        for (int i = 0; i < m; i++) {
            result = result.multiply(BigInteger.valueOf(n-i));
            result = result.divide(BigInteger.valueOf(i+1));
        }

        System.out.println(result);
    }
}
