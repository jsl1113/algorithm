package com.example.algorithm.study.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 아니.. 열받네..?
// 결론은 못 풀었다.
// 예제는 다 맞게 나오고 정답이라고 생각했는데,,
// 답을 보려고 해도 푼 사람 얼마 있지도 않아서 .. 틀렸습니다 를 해결 못 했다. 흠
// 해결했습니다.
public class B1503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[1002];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[Integer.parseInt(st.nextToken())] = 1;
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= 1000; i++) {
            for (int j = i; j <= 1000; j++) {
                for (int k = j; k <= 1001; k++) {
                    if (arr[k] == 1 || arr[j] == 1 || arr[i] == 1) {
                        continue;
                    }

                    answer = Math.min(answer, Math.abs(n - i * j * k));
                }
            }
        }

        System.out.println(answer);
    }
}
