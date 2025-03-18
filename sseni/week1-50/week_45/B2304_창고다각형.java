package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2304_창고다각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Bar[] arr = new Bar[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Bar(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, (a, b) -> a.L - b.L);

        int answer = 0, max = 0;
        Bar bar = arr[0];
        for (int i = 1; i < n; i++) {
            Bar current = arr[i];

            if (bar.H <= current.H) {
                answer += (current.L - bar.L) * bar.H;
                bar = current;
                max = i;
            }
        }

        bar = arr[n - 1];
        for (int i = 1; i < n - max; i++) {
            Bar current = arr[(n - 1) - i];

            if (bar.H <= current.H) {
                answer += (bar.L -  current.L) * bar.H;
                bar = current;
            }
        }

        System.out.println(answer + arr[max].H);
    }

    static class Bar {
        int L, H;

        Bar(int L, int H) {
            this.L = L;
            this.H = H;
        }

        public String toString() {
            return L + " " + H;
        }
    }
}
