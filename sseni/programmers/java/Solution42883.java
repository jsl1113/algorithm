package com.example.javaproject3.psstudy;

public class Solution42883 {
    public String solution(String number, int k) {
        int idx = 0;  // 구한 자리의 다음 인덱스를 가리킴
        StringBuilder sb = new StringBuilder();
        /*
        ex. 4177252841, 4 인 경우, 6자리의 큰 수를 구함
        -> 한 자릿수를 구할 때 앞에서부터 이미 구한 자리의 다음 인덱스부터 제일 큰 값을 탐색
        첫 번째 자릿수가 올 수 있는 위치는 41772 까지 = 7
        두 번째 자릿수가 올 수 있는 위치는 (17)725 까지 = 7
        세 번째 자릿수가 올 수 있는 위치는 (77)252 까지 = 5
        네 번째 자릿수가 올 수 있는 위치는 (725) 28 까지 = 8
        다섯 번째 자릿수가 올 수 있는 위치는 (2528) 4 까지  = 4
        여섯 번째 자릿수가 올 수 있는 위치는 (5284) 1 까지 = 1
        = 775841
        */
        for (int i = 0; i < number.length() - k; i++) {  // 총 길이에서 k 만큼 제거한 만큼 반복
            int max = Integer.MIN_VALUE; // 자리 마다 max 값을 구해 sb 를 더해줌
            for (int j = idx; j < (i + k + 1); j++) {  // 이전에 구한 자리 다음 인덱스 부터 시작해서 최대 올 수 있는 자리까지 탐색
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0'; // 더 큰 값으로 갱신
                    idx = j + 1; // 큰 값의 다음 인덱스를 저장
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution42883().solution("1231234", 3));
        System.out.println(new Solution42883().solution("1924", 2));
        System.out.println(new Solution42883().solution("4177252841", 4));
    }
}
