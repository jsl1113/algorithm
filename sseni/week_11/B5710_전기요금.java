package com.example.algorithm.study.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 각각의 사용량을 이분 탐색, B 값 가지고 검사
// 문제 이해 부터 한 세월 ... 의문 : 어떻게 요금에서 사용량을 구하는 거지 ? 에서 한참 걸렸다.
// 그냥 사용량 -> 요금 메소드의 반대인건데 왜 오래 걸렸지
// 어떤 부분에서 이분 탐색을 할 지는 알았다.
// ( 700,400 / 350,650, B에 따라서 사용량 경우의 수가 여러개인 점에서 떠올림 )
public class B5710_전기요금 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) return;

            int total = calWattHour(a);  // 총 사용량에 따른 총 요금
            int start = 0, end = total / 2;
            while (start <= end) {
                int mid = (start + end) / 2;
                int x = calCost(mid);  // 상근이
                int y = calCost(total - mid);  // 이웃

                int tmp = Math.abs(x - y);
                if (tmp > b) start = mid + 1;
                else if (tmp < b) end = mid - 1;
                else {
                    System.out.println(calCost(mid));
                    break;
                }
            }
        }
    }

    public static int calCost(int n) {  // 사용량에 따라, 내야 할 요금
        if (n <= 100) return 2 * n;
        else if (n <= 10_000) return 200 + 3 * (n - 100);
        else if (n <= 1_000_000) return 29_900 + 5 * (n - 10_000);
        else return 4_979_900 + 7 * (n - 1_000_000);
    }

    public static int calWattHour(int n) { // 전기 요금에 따른 사용량
        if (n <= 200) return n / 2;
        else if (n <= 29_900) return (n - 200) / 3 + 100;
        else if (n <= 4_979_900) return (n - 29_900) / 5 + 10_000;
        else return (n - 4_979_900) / 7 + 1_000_000;
    }
}
