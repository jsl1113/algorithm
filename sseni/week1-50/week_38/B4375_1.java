package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// 이전에 Long 보다 큰 수를 표현할 때, BigInteger 썼던 기억으로 써먹음
public class B4375_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        while ((str = br.readLine()) != null) {
            System.out.println(func(str));
        }
    }

    static int func(String s) {
        BigInteger num = new BigInteger(s);
        BigInteger div = BigInteger.ZERO;

        while (true) {
            div = div.multiply(BigInteger.TEN).add(BigInteger.ONE);

            if (div.mod(num).equals(BigInteger.ZERO)) {
                break;
            }
        }

        return div.toString().length();
    }
}
