package com.example.javaproject3.psstudy;

import java.util.*;

public class Solution42839 {
    public int solution(String numbers) {
        HashSet<Integer> hs = new HashSet<>();              // 중복되는 수를 방지하기 위해 HashSet 으로
        numCombinations("", numbers, hs);                // 조합할 수 있는 경우의 수를 구하는 메소드
        System.out.println(Arrays.toString(hs.toArray()));
        return cntPrime(hs.toArray(Integer[]::new));         // 소수인 수를 카운트하는 메소드 리턴
    }

    public void numCombinations(String str, String tmp, HashSet<Integer> hs) {
        if (!str.equals("")) hs.add(Integer.parseInt(str));     // str 이 공백이 아니면 hs 에 Integer 로 변환하여 add
        for (int i = 0; i < tmp.length(); i++) {                    // 남은 숫자 개수만큼 반복
            // 한 숫자를 추가한 str, 추가한 숫자 제외한 tmp, hashset 을 파라미터로 재귀 메소드 호출
            numCombinations(str + tmp.substring(i, i + 1),tmp.substring(0, i) + tmp.substring(i + 1), hs);
        }
    }

    public int cntPrime(Integer[] arr){                 // 소수를 카운트하는 메소드
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {           // 배열의 크기만큼 반복
            if (isPrime(arr[i]))                                // 해당 숫자가 소수이면
                cnt++;
        }
        return cnt;                                             // 배열에서 소수 개수를 카운트한 변수 리턴
    }

    public boolean isPrime(int num) {               // 소수 판별 메소드
        if (num <= 1) return false;                       // 1 보다 작으면 false 리턴
        for (int i = 2; i * i <= num; i++) {             // 수의 제곱근까지 반복
            if (num % i == 0) return false;            // 나눠지면 false 리턴
        }
        return true;                                           // 소수임으로 true 리턴
    }

    public static void main(String[] args) {
        Solution42839 solution42839 = new Solution42839();
        System.out.println(solution42839.solution("123"));
    }
}
