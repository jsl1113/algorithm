package com.example.algorithm.study.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 다음 노드로 큰 수가 나오면 오른쪽 노드, 작은 수가 나오면 왼쪽 노드
public class B5639_이진검색트리 {
    static Node root;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        root = new Node(Integer.parseInt(br.readLine()), null, null);

        while (true) {
            String s = br.readLine();
            if(s == null || s.equals("")) break;
            Node node = new Node(Integer.parseInt(s), null, null);
            addNode(root, node);
        }

        postOrder(root);
        System.out.println(sb);
    }

    static void addNode(Node node, Node next) {
        if (next.num < node.num) {
            if(node.left != null) addNode(node.left, next);
            else node.left = next;
        } else {
            if(node.right != null) addNode(node.right, next);
            else node.right = next;
        }
    }

    static void postOrder(Node node) {
        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);
        sb.append(node.num).append("\n");
    }

    static class Node {
        int num;
        Node left, right;

        Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }
}
