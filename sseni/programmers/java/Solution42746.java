package com.example.javaproject3.psstudy;

import java.util.Arrays;
import java.util.Comparator;

public class Solution42746 {
    public String solution(int[] numbers) {
        // int형 배열을 String 형 배열로 변환
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) arr[i] = String.valueOf(numbers[i]);
        Arrays.sort(arr, new Comparator<String>() {  // String 배열을 내림차순 정렬 ( 9와 30을 비교했을 때, 930 > 309 이므로, 9, 30 순으로 정렬됨 )
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if(arr[0].equals("0")) return "0";  // 내림차순으로 정렬한 상태이기 때문에, 맨 앞의 값이 0이면, 0 리턴
        return String.join("", arr);  // 배열을 join 으로 연결해 문자열로 리턴
    }

    public static void main(String[] args) {
        Solution42746 solution42746 = new Solution42746();
        solution42746.solution(new int[]{3, 30,34, 5, 9});
    }
}
