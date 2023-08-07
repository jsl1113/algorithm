package com.example.javaproject3.pg;

import java.util.Arrays;
import java.util.Scanner;

public class Solution120852_ {
    public static void main(String[] args) {
        int n = 12;
        int divisor = 2;
        int[] arr = new int[n + 1]; // 12개나 만들어야하나?
        // dynamic programming
        //         List, Set, Map
        int idx = 0;
        while (n > 1) {
            if (n % divisor == 0) {
                arr[idx++] = divisor;
                n /= divisor;
            } else {
                divisor++;
            }
        }
        // 0이 아닌 숫자의 개수 O(n)
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                size++;
            }
        }

        // 0이 아닌 숫자를 앞에부터 넣기 O(n)
        int[] answer = new int[size];
        idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                answer[idx++] = arr[i];
            }
        }

        System.out.println(Arrays.toString(answer));

    }
}