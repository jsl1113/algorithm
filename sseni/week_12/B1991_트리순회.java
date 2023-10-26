package com.example.algorithm.study.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 그냥 루트 노드에 대해서 순회하면 돼서 리스트에 따로 저장할 필요가 없었다.
// 순회는 어렵지 않았지만 노드를 추가하는 메소드가 조금 걸렸다.
public class B1991_트리순회 {
    static int n;
//    static List<Node> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Node root = new Node('A', null, null);
        for (int i = 0; i < n; i++) {
            String[] strArray = br.readLine().split(" ");
            char parent = strArray[0].charAt(0);
            char left = strArray[1].charAt(0);
            char right = strArray[2].charAt(0);
            addNode(root, parent, left, right);
        }

        preorderTraversal(root);
        sb.append("\n");
        inorderTraversal(root);
        sb.append("\n");
        postorderTraversal(root);
        System.out.println(sb.toString());
    }

    public static void addNode(Node node, char parent, char left, char right) {
        if (node.parent == parent) {
            node.left = (left == '.' ? null : new Node(left, null, null));
            node.right = (right == '.' ? null : new Node(right, null, null));
//            list.add(node);
        } else {
            if(node.left != null) addNode(node.left, parent, left, right);
            if(node.right != null) addNode(node.right, parent, left, right);
        }
    }

    public static void preorderTraversal(Node node) {
        sb.append(node.parent);
        if(node.left != null) preorderTraversal(node.left);
        if(node.right != null) preorderTraversal(node.right);
    }

    public static void inorderTraversal(Node node) {
        if(node.left != null) inorderTraversal(node.left);
        sb.append(node.parent);
        if(node.right != null) inorderTraversal(node.right);
    }

    public static void postorderTraversal(Node node) {
        if(node.left != null) postorderTraversal(node.left);
        if(node.right != null) postorderTraversal(node.right);
        sb.append(node.parent);
    }

    static class Node {
        char parent;
        Node left;
        Node right;

        public Node(char parent, Node left, Node right) {
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

//        public String toString() {
//            StringBuilder sb = new StringBuilder();
//            sb.append(parent).append(" ");
//            sb.append(this.left == null ? "null" : this.left.parent).append(" ");
//            sb.append(this.right == null ? "null" : this.right.parent).append(" ");
//            return sb.toString();
//        }
    }
}
