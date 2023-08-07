package com.example.javaproject3.codeup;

import java.util.Scanner;

public class CodeUp1023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.next().split("\\.");
        // split("[.]") 도 가능 (escape 와 정규 표현식 차이)
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }
}
