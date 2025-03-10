package com.example.algorithm.study.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 처음에 이진 트리라고 당연하게 생각하고
// 클래스를 왼쪽 노드, 오른쪽 노드라고 설정해버렸다
public class B1068_트리 {
    static Node[] nodeList;
    static Node root;
    static int n, d, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nodeList = new Node[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) nodeList[i] = new Node(i);
        for (int i = 0; i < n; i++) {
            int node = Integer.parseInt(st.nextToken());
            if(node == -1) root = nodeList[i];
            else nodeList[node].leafList.add(nodeList[i]);
        }

        d = Integer.parseInt(br.readLine());
        if (d != root.num) {
            // 노드 삭제
            deleteNode(root.num);
            // 리프 노드 카운트
            cntLeafNode(root.num);
        }

        System.out.println(answer);
    }

    static void deleteNode(int num) {
        for (Node node : nodeList[num].leafList) {
            if(node.num == d){
                nodeList[num].leafList.remove(node);
                return;
            }
            deleteNode(node.num);
        }
    }

    static void cntLeafNode(int num) {
        if (nodeList[num].leafList.size() == 0) {
            answer++;
            return;
        }

        for (Node node : nodeList[num].leafList) {
            cntLeafNode(node.num);
        }
    }

    static class Node {
        int num;
        List<Node> leafList = new ArrayList<>();

        public Node(int num) {
            this.num = num;
        }
    }
}
