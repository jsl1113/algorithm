package com.example.javaproject3.psstudy;

import java.util.Arrays;
import java.util.Comparator;

public class Solution42892 {
    int[][] answer; // 순회 결과 배열
    int idx = 0;  // 순회를 위한 index 변수
    static class Node {  // 노드 클래스
        int x, y, num;
        Node left;
        Node right;
        /*
        num : 해당 노드의 번호
        x, y : 해당 노드의 좌표
        left, right : 해당 노드의 자식 노드
        */
        public Node(int num, int x, int y, Node left, Node right) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.right = right;
            this.left = left;
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) // nodeinfo 에 따라 노드 객체 생성해서 배열에 저장
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null);

        Arrays.sort(nodes, new Comparator<Node>() { // 노드를 좌표 중, y 값 기준으로 정렬
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.y == o2.y) return o1.x - o2.x;  // y 값이 같다면, x 값 기준으로 졍렬
                return o2.y - o1.y;
            }
        });

        Node root = nodes[0]; // 부모 노드
        for (int i = 1; i < nodes.length; i++)
            makeTree(root, nodes[i]); // 이진 트리 메소드 호출

        answer = new int[2][nodeinfo.length];
        preorder(root); // 전위 순회
        idx = 0; // 인덱스 초기화
        postorder(root); // 후위 순회
        return answer;
    }

    public void makeTree(Node root, Node child) { // 이진 트리 메소드
        if (root.x < child.x) {  // 자식 노드의 x 값이 부모 노드의 x 값보다 클 경우, 부모 노드의 오른쪽 서브 트리에 해당됨
            if (root.right == null) root.right = child; // null 이면, 해당 노드를 자식 노드로 설정
            else makeTree(root.right, child); // 오른쪽 자식 노드를 부모 노드로 설정하고 자식 노드와 재귀 호출
        } else {  //부모 노드의 왼쪽 서브 트리
            if (root.left == null) root.left = child;
            else makeTree(root.left, child);
        }
    }

    public void preorder(Node root) { // 전위 순회 메소드 (V -> L -> R)
        if (root != null) {
            answer[0][idx++] = root.num; // 루트 노드 번호 저장
            preorder(root.left); // 루트 노드의 왼쪽 서브 트리 순회
            preorder(root.right); // 루트 노드의 오른쪽 서브 트리 순회
        }
    }

    public void postorder(Node root) { // 후위 순회 메소드 (L -> R -> V)
        if (root != null) {
            postorder(root.left); // 루트 노드의 왼쪽 서브 트리 순회
            postorder(root.right); // 루트 노드의 오른쪽 서브 트리 순회
            answer[1][idx++] = root.num; // 루트 노드 번호 저장
        }
    }

    public static void main(String[] args) {
        int[][] ans = new Solution42892().solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}});
        for (int i = 0; i < 2; i++)
            System.out.println(Arrays.toString(ans[i]));
    }
}
