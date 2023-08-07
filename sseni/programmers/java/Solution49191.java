package com.example.javaproject3.psstudy;

public class Solution49191 {
    public void update(int[][] graph, int i, int j){  // 그래프 업데이트
        graph[i][j] = 1;  // i 가 j 를 이김 -> 1 저장
        graph[j][i] = -1; //  j 가 i 에게 짐 -> -1 저장
    }
    public int solution(int n, int[][] results){
        int answer = n;
        int[][] graph = new int[n+1][n+1];

        for(int[] r : results)  // 순위에 따라 배열에 반영
            update(graph, r[0], r[1]);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if(graph[j][i] == 1 && graph[i][k] == 1) // a > b 이고, b > c 이면, 자동적으로 a > c
                        update(graph, j, k);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i != j && graph[i][j] == 0) { // 자기 자신을 제외하고, 0 이 하나라도 있으면 순위를 알 수 없음
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        new Solution49191().solution(5, new int[][]{{4,3},{4,2},{3,2},{1,2},{2,5}});

    }
}
