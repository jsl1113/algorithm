package com.example.algorithm.study.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 연산자 : n/2 피연산자 : n/2 + 1
// 괄호를 넣는지, 안 넣는지 를 모두 계산하면서 갱신하는 것이 브루트포스인 건 앎..
// dfs 냄새가 나긴 났음, (해당 자리에) 괄호를 넣고 계산 & 안 넣고 계산
// 근데 dfs 에 넣는 idx 를 어떤 방식으로 갱신해야 하는지 생각하지 못했다.
public class B16637_괄호추가하기 {
    static int n, max;
    static ArrayList<Integer> numList;
    static ArrayList<Character> opList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numList = new ArrayList<>();
        opList = new ArrayList<>();
        String str = br.readLine();

        max = Integer.MIN_VALUE;
        char[] input = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) numList.add(input[i] - '0');
            else opList.add(input[i]);
        }

        dfs(0, numList.get(0));
        System.out.println(max);
    }

    public static void dfs(int idx, int sum) {
        if (idx >= opList.size()) {
            max = Math.max(max, sum);
            return;
        }

        // 괄호 안 넣기
        dfs(idx + 1, cal(sum, numList.get(idx + 1), opList.get(idx)));

        // 괄호 넣기
        if (idx + 1 < opList.size()) {
            // 3+8*7-9*2 이고, idx가 0 일 때,
            // numList = [3, 8, 7, 9, 2]
            // opList = [+, *, -, *]
            // tmp = cal(8, 7, *) = 56
            // dfs(2, cal(3, 56, +)) 호출, 이런 식으로 "괄호를 넣는다" 는 계산
            // sum 의 오른쪽에 있는 값들 연산하고, sum 이랑 방금 나온 값이랑 계산해서 재귀로 넘김
            int tmp = cal(numList.get(idx + 1), numList.get(idx + 2), opList.get(idx + 1));
            dfs(idx + 2, cal(sum, tmp, opList.get(idx)));
        }
    }

    public static int cal(int a, int b, char oper) {
        int result = 0;
        switch (oper) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
        }
        return result;
    }
}
