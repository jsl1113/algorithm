package com.example.javaproject3.psstudy;

public class Solution43165 {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);  // DFS
        return answer;
    }

    public void dfs(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) { // 모든 수를 탐색했을 때,
            if (sum == target) answer++; // 합이 target과 같다면 answer add
            return;
        }
        dfs(numbers, target, idx + 1, sum + numbers[idx]);  // 현재 숫자를 더해준 후 DFS 수행
        dfs(numbers, target, idx + 1, sum - numbers[idx]); // 현재 숫자를 뺴준 후 DFS 수행
    }

    public static void main(String[] args) {
        System.out.println(new Solution43165().solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(new Solution43165().solution(new int[]{4, 1, 2, 1}, 4));
    }
}
