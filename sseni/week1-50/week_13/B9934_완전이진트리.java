package com.example.algorithm.study.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B9934_완전이진트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[(int) Math.pow(2, k)];
        for (int i = 0; i < Math.pow(2, k) - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(k, arr));
    }

    static String solution(int k, int[] arr) {
        List<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(new ArrayList<>());
        }

        CompleteBinaryTree(0, arr.length - 1, 0, k, arr, list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            for (int num : list.get(i)) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    static void CompleteBinaryTree(int start, int end, int depth, int k, int[] arr, List<ArrayList<Integer>> list) {
        if(depth == k) return;
        int mid = (start + end) / 2;
        list.get(depth).add(arr[mid]);

        CompleteBinaryTree(start, mid - 1, depth + 1, k, arr, list);
        CompleteBinaryTree(mid + 1, end, depth + 1, k, arr, list);
    }
}
