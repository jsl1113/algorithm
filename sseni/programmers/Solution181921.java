package com.example.javaproject3.pg;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution181921 {
    public static boolean isZeroOrFive(int num){  // 숫자 0 과 5로 이루어져 있는지 판단하는 메소드
        while(num > 0){
            if(num % 10 != 5 && num % 10 != 0) { // 10으로 나눈 나머지가 0, 5가 아닐 때
                return false;
            }
            num /= 10; // 10으로 나눠지기 때문에, 나눈 몫을 num에 누적해서 대입
        }
        return true;
    }

    public int[] solution(int l, int r) {
        int[] answer = {-1};
        int[] result = new int[(r-l)/5];
        int idx = 0; // 0과 5로 이루어진 정수 개수 index
        for(int i=l; i<=r; i++){  // 메소드를 호출하여 0과 5로 이루어져 있다면 result 배열에 저장 후 index 1 증가
            if(isZeroOrFive(i)) result[idx++] = i;
        }
        if(idx == 0) return answer;  // index가 0이라면(배열이 비어있다면) -1 만 담긴 배열 return
        else {
            answer = new int[idx];  //  answer 배열을 idx 만큼의 크기로 초기화
            for(int i=0; i<idx; i++) answer[i] = result[i];  // result 배열의 값을 answer 배열에 저장
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution181921 solution181921 = new Solution181921();
        System.out.println(Arrays.toString(solution181921.solution(5, 555)));
    }
}
