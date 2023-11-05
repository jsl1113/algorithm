package com.example.algorithm.study.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RV_B1991_트리순회 {
    static int n;
    static Node root = new Node('A', null, null);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] strArray = br.readLine().split(" ");
            char a = strArray[0].charAt(0);
            char b = strArray[1].charAt(0);
            char c = strArray[2].charAt(0);
            addNode(root, a, b, c);
        }

        preorder(root);
        sb.append("\n");
        inorder(root);
        sb.append("\n");
        postorder(root);
        System.out.println(sb);
    }

    static void preorder(Node node) {
        sb.append(node.num);
        if(node.left != null) preorder(node.left);
        if(node.right != null) preorder(node.right);
    }

    static void inorder(Node node) {
        if(node.left != null) inorder(node.left);
        sb.append(node.num);
        if(node.right != null) inorder(node.right);
    }

    static void postorder(Node node) {
        if(node.left != null) postorder(node.left);
        if(node.right != null) postorder(node.right);
        sb.append(node.num);
    }

    static void addNode(Node node, char num, char left, char right) {
        if (node.num == num) {
            node.left = left == '.' ? null : new Node(left, null, null);
            node.right = right == '.' ? null : new Node(right, null, null);
        } else {
            if(node.left != null) addNode(node.left, num, left, right);
            if(node.right != null) addNode(node.right, num, left, right);
        }
    }

    static class Node {
        char num;
        Node left, right;

        Node(char num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }
}
