package com.example.javaproject3.psstudy;

public class Solution67256 {

    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;  // * 위치를 10 이라 지정
        int right = 12;  // # 위치를 12 라 지정
        for (int num : numbers) {
            if(num == 0) num += 11;

            String finger = pushNumber(num, left, right); // 번호에 따라 사용할 손을 반환하는 메소드 호출
            if (finger.equals("L")) {  // 왼손일 경우
                answer += finger;
                left = num;
            } else if (finger.equals("R")) { // 오른손일 경우
                answer += finger;
                right = num;
            } else { // 두 엄지 손 가락의 거리가 같다면,
                if (hand.equals("left")) {  // 왼손잡이일 경우
                    answer += "L";
                    left = num;
                } else {  // 오른손잡이일 경우
                    answer += "R";
                    right = num;
                }
            }
        }
        return answer;
    }

    public String pushNumber(int num, int left, int right) {
        if (num == 1 || num == 4 || num == 7) return "L";  // 왼쪽 열일 경우, 왼손 반환
        else if (num == 3 || num == 6 || num == 9) return "R";  // 오른쪽 열일 경우, 오른손 반환
        else {
            int keypadLeft = (Math.abs(num - left)) / 3 + (Math.abs(num - left)) % 3;  // 왼손 엄지 손가락과 숫자 간 거리 계산
            int keypadRight = (Math.abs(num - right)) / 3 + (Math.abs(num - right)) % 3; // 오른손 엄지 손가락과 숫자 간 거리 계산
            if (keypadLeft < keypadRight) return "L";
            else if (keypadLeft > keypadRight) return "R";
            else return "hand"; // 두 거리가 같다면, "hand"를 반환하여 오른손잡이/왼손잡이 로 구분
        }
    }

    public static void main(String[] args) {
        // LRLLRRLLLRR
        System.out.println(new Solution67256().solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
    }
}
