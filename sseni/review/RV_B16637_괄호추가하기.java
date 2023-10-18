package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. 부분 집합으로 괄호를 추가할 수 있는 경우의 수 계산하기
// 2. 수식 계산하기
// 3. 최댓값 갱신하기
// DFS로 풀었던 저번 과는 다르게, 비트마스킹으로 경우의 수를 찾고,
// 경우의 수에 맞게, 수식을 계산하는 방법으로 풀었다.
// ( 처음에 14%에서 틀렸던 이유 : 답이 음수가 될 수 있는데, answer 를 0 으로 초기화해서 )
public class RV_B16637_괄호추가하기 {
    static int n;
    static String str;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        str = br.readLine();
        int[] num = new int[n / 2 + 1];  // 숫자 배열
        char[] op = new char[n / 2]; // 연산자 배열

        if (n == 1) {
            System.out.println(str);
            return;
        }

        for (int i = 0; i < n; i++) { // 숫자와 연산자를 분리해서 저장
            if (i % 2 == 0) num[i / 2] = str.charAt(i) - '0';
            else op[i / 2] = str.charAt(i);
        }

        // 연산자 개수를 받아, 수식에 괄호를 넣을 수 있는 경우의 수 메소드 호출
        // ex. [+, *, -, *] 라면, [ [], [0], [1], [2], [3], [0,2], [1,3], [0,3] ] 이 list에 담김
        list = makeCase(n / 2);

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {  // 각각 경우의 수마다 최댓값 갱신
            answer = Math.max(answer, solve(list.get(i), num, op));
        }
        System.out.println(answer);
    }

    // 괄호끼리 경우의 수를 비트마스킹으로 구하는 메소드
    // op 배열의 인덱스로 경우의 수를 구함
    public static List<List<Integer>> makeCase(int n) {
        Set<List<Integer>> set = new HashSet<>(); // 경우의 수 중복 방지를 위해 Set

        for (int i = 0; i < (1 << n); i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    // 비트마스킹으로 경우의 수 구하기
                    // 단, 연속적으로 괄호를 칠 수 없다
                    // ex. (3 + (8) * 7) -> ??
                    if (j == 0) list.add(j);
                    else if (!list.contains(j - 1)) list.add(j);
                }
            }
            set.add(list);
        }

        // Set to List
        return new ArrayList<>(set);
    }

    // 추가한 괄호 경우의 수 cases 에 맞게 수식 계산하기
    public static int solve(List<Integer> cases, int[] num, char[] op) {
        int result = num[0];

        if (cases.isEmpty()) {  // 괄호를 치지 않으면, 그냥 num과 op 가지고 차례로 계산하면 됨
            for (int i = 1; i < num.length; i++) {
                int tmp = num[i];
                result = cal(result, tmp, op[i - 1]);
            }
            return result;
        }

        // 괄호가 쳐진 부분을 미리 계산해놓기
        // ex. 3+8*7-9*2 이고, cases = [1] 이라면,
        // stack에는 [3, 56, 9, 2] 가 저장된다.
        Stack<Integer> stack = new Stack<>();
        stack.push(num[0]);
        for (int i = 0; i < op.length; i++) {
            stack.push(num[i + 1]);
            if (cases.contains(i)) {
                int x = stack.pop();
                int y = stack.pop();
                stack.add(cal(y, x, op[i]));
            }
        }

        List<Integer> list = new ArrayList<>(stack);  // Stack to List

        // 수식 계산
        result = list.get(0);
        int numIdx = 1,  opIdx = 0; // 숫자 idx, 연산자 idx
        while (numIdx < list.size()) {
            int tmp = list.get(numIdx);
            if(cases.contains(opIdx)) opIdx++;  // 이미 계산한 연산자라면, 연산자 idx 증가

            result = cal(result, tmp, op[opIdx]);
            opIdx++;
            numIdx++;
        }

        return result;
    }

    public static int cal(int a, int b, char op) {
        int sum = 0;
        switch (op) {
            case '+' -> sum = a + b;
            case '-' -> sum = a - b;
            case '*' -> sum = a * b;
        }
        return sum;
    }
}
