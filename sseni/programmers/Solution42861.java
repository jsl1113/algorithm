package com.example.javaproject3.psstudy;

import java.util.*;

public class Solution42861 {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        // 건설 비용이 낮은 순으로 정렬한 후, 연결 시작
        // 각 노드의 부모가 같지 않으면
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));  // 크루스칼 알고리즘 위해 가중치 기준 오름차순 정렬

        parent = new int[n]; // parent 배열 선언
        for(int i=0; i<n; i++)  // 자기 자신으로 부모 초기화
            parent[i] = i;

        for(int[] c : costs){
            // 해당 섬의 부모 노드가 같지 않으면, 최솟값 가중치를 가진 연결이 안된 섬이므로 해당 다리를 선택
            if(findParent(c[0]) != findParent(c[1])) {
                // 간선을 연결해 두 노드를 같은 그래프로 합침, end의 부모 노드를 start의 부모 노드로 갱신 (union)
                parent[findParent(c[1])] = parent[findParent(c[0])];
                answer += c[2];  // 비용 업데이트
            }
        }
        return answer;
    }

    // findParent : 부모 노드가 자기 자신과 같은 노드를 찾을 때까지 재귀 호출
    private int findParent(int node){
        if(parent[node] != node)
            return findParent(parent[node]);
        else
            return node;
    }

    public static void main(String[] args) {
        System.out.println(new Solution42861().solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
    }
}
