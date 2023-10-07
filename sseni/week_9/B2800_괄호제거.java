package com.example.algorithm.study.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// dfs 생각, 제거할 괄호를 선택하고 재귀 호출
// 쌍이 되는 괄호를 어떻게 판단할 수 있을까?
// 먼저 스택을 사용해서 쌍이 되는 괄호를 리스트에 저장
// 처음에 틀린 이유 : 중복되는 결과는 제거해야 한다 -> TreeSet 으로 변경 (TreeSet : 정렬되어 있는 Set)
// refactoring >> 부분 집합을 구하는 과정을 비트마스킹으로 변경
public class B2800_괄호제거 {
    static String input;
    static ArrayList<int[]> arrayList;
    static Set<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        arrayList = new ArrayList<>();
        answer = new TreeSet<>();

        Stack<Integer> stack = new Stack<>();
        getPairOfBracket(stack);

//        boolean[] visited = new boolean[arrayList.size()];
//        dfs(0, visited, new ArrayList<>());

        // 괄호 부분 집합 구하기
        for (int i = 1; i <= (1 << arrayList.size()); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < arrayList.size(); j++) {
                if((i & (1 << j)) != 0) {
                    list.add(arrayList.get(j)[0]);
                    list.add(arrayList.get(j)[1]);
                }
            }
            if(!list.isEmpty()) answer.add(removeString(list));
        }

        StringBuilder sb = new StringBuilder();
        for (String s : answer) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    public static void getPairOfBracket(Stack<Integer> stack) {
        // 쌍이 되는 괄호 구하기
        int start = input.indexOf('(');
        stack.push(start);
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '(' && c != ')') continue;
            if (c == '(') {
                stack.push(i);
            } else {
                arrayList.add(new int[]{stack.pop(), i});
            }
        }
    }

    public static String removeString(List<Integer> idxList) {
        // 제거할 인덱스 리스트를 역순으로 정렬 후, deleteCharAt (앞에서부터 제거하면 인덱스가 밀린다)
        StringBuilder result = new StringBuilder(input);
        idxList.sort((a, b) -> Integer.compare(b, a));
        for (int idx : idxList) {
            if (idx >= 0 && idx < result.length()) {
                result.deleteCharAt(idx);
            }
        }
        return result.toString();
    }

    public static void dfs(int idx, boolean[] visited, List<int[]> list) {
        if (!list.isEmpty()) {
            List<Integer> idxList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                idxList.add(list.get(i)[0]);
                idxList.add(list.get(i)[1]);
            }

            answer.add(removeString(idxList));
        }

        for (int i = idx; i < arrayList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(arrayList.get(i));
                dfs(i + 1, visited, list);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
