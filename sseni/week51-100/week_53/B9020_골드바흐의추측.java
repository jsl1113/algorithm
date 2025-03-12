package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B9020_골드바흐의추측 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] testCase = new int[T];

        int max = 0;
        for (int i = 0; i < T; i++) {
            testCase[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, testCase[i]);
        }

        boolean[] isPrime = isPrime(max);

        StringBuilder sb = new StringBuilder();
        for (int n : testCase) {
            int prime1 = 0, prime2 = 0;
            int minDiff = Integer.MAX_VALUE;

            for (int i = 2; i <= n / 2; i++) {
                if (isPrime[i] && isPrime[n - i]) {
                    int diff = Math.abs(i - (n - i));
                    if (diff < minDiff) {
                        prime1 = i;
                        prime2 = n - i;
                        minDiff = diff;
                    }
                }
            }
            sb.append(prime1).append(" ").append(prime2).append("\n");
        }

        System.out.println(sb);
    }

    static boolean[] isPrime(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= max; i++) {
            for (int j = i * i; j <= max; j += i) {
                isPrime[j] = false;
            }
        }

        return isPrime;
    }
}
