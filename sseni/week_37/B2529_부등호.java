package com.example.algorithm.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class B2529_부등호 {
    static int k;
    static char[] arr;
    static int[] numArray;
    static boolean[] visited = new boolean[10];
    static long[] answer;
    static String min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        numArray = new int[k + 1];
        arr = new char[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        answer = new long[2];
        answer[0] = Long.MAX_VALUE;
        answer[1] = Long.MIN_VALUE;

        dfs(0);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int cnt) {
        if (cnt == k + 1) {
            if (check()) {
                // 배열을 스트림으로 변환 -> 숫자를 문자열로 -> 문자열로 결합 -> Long 숫자로 변환
                String s = Arrays.stream(numArray).mapToObj(String::valueOf).collect(Collectors.joining());
                long n = Long.parseLong(s);

                if (answer[0] > n) {
                    answer[0] = n;
                    min = s;
                }

                if (answer[1] < n) {
                    answer[1] = n;
                    max = s;
                }
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                numArray[cnt] = i;
                visited[i] = true;
                dfs(cnt + 1);
                visited[i] = false;
            }
        }
    }

    static boolean check() {  // 부등호에 맞는 숫자 배열인지 체크
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '>') {
                if (numArray[i] <= numArray[i + 1]) {
                    return false;
                }
            } else {
                if (numArray[i] >= numArray[i + 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
