package com.example.javaproject3.pg;


public class Solution17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++){
//            String str = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
//            str = str.substring(str.length()-n).replaceAll("1", "#").replaceAll("0", " ");
//            answer[i] = str;
            answer[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i]))
                    .replaceAll("1", "#").replaceAll("0", " ");
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution17681 solution176811 = new Solution17681();
        solution176811.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        solution176811.solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10});
    }
}
