package com.example.algorithm.study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 사실 조금 집중이 안 돼서 깊게 생각하지 못했다.
// 그래서 파이썬으로 풀었던 예전의 내 코드를 보고 풀어서 통과했다.. (이거도 통과한 코드, 점화식보다 효율 좋음. 의외)
// 근데 답을 찾아보니 내 코드같은 스타일은 아예 없고 다들 점화식으로 풀었다네 ? 사실 흐름은 비슷하다
// 점화식도 생각했는데 귀찮아서 안 써보고 생각만으로 과연 규칙이 있나 ? 라는
// 안일한 생각을 했다... 암튼 그렇다... dp 문제는 어떻게든 점화식은 존재한다.
// 규칙이 보일 때까지 하나씩 써보자 다음에는
public class B17626_Before {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 1; i <= (int) Math.sqrt(n); i++) { // 한 제곱수를 넣은 리스트
            list1.add((int) Math.pow(i, 2));
        }

        for (int i = 1; i <= (int) Math.sqrt(n); i++) {  // 두 제곱수를 더한 리스트
            for (int j = i; j <= (int) Math.sqrt(n); j++) {
                list2.add((int) (Math.pow(i, 2) + (Math.pow(j, 2))));
            }
        }

        int answer = 4;  // 4로 초기화해놓고
        if (list1.contains(n)) answer = 1;  // list1 에 있으면 한 수로 만들 수 있음
        else if (list2.contains(n)) answer = 2;  // list2 에 있으면 두 수로 만들 수 있음
        else {
            for (int m : list1) {  // list2 를 돌면서
                if (list2.contains(n - m)) { // 만약, n-m 이 list2에 있다면? n-m 과 m 으로 만들 수 있음
                    answer = 3; // m 은 두 수로 이루어져 있기 때문에 3 리턴
                }
            }
        }

        // 사실 이건 자연수를 넷 혹은 그 이하의 제곱수 합으로 나타낼 수 있다. 때문에 가능한 풀이
        System.out.println(answer);
    }
}
