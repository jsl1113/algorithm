package com.example.javaproject3.psstudy;

import java.util.*;

public class Solution67257 {
    List<String> op = new ArrayList<>();                                // 연산자 list
    List<Long> operand = new ArrayList<>();                         // 피연산자 list
    List<List<String>> list = new ArrayList<>();                     // 연산자 우선 순위 경우의 수 리스트를 담은 리스트
    boolean[] isVisit = new boolean[3];                                  // 연산자 우선 순위 경우의 수를 계산 시, 추가한 연산자 boolean 처리 위해
    String[] oper = {"+", "-", "*"};

    public long solution(String expression) {
        long answer = 0;
        separationExpressions(expression);                                //  연산자, 피연산자 분리 메소드 호출
        combinationOperators(new ArrayList<>(), oper, isVisit);      // 연산자 경우의 수 계산하는 메소드 호출
        // 연산자 재정의한 경우의 수마다
        // 한 경우의 수, 연산자, 피연산자를 파라미터로 계산하는 메소드를 호출하여 결과값이랑 answer 중 큰 값 비교
        for (List<String> l : list) {
            answer = Math.max(answer, calculation(l, operand, op));
        }
        return answer;
    }

    public void separationExpressions(String expression) {  // 연산자, 피연산자 분리 메소드
        String tmp = "";                                                        // 피연산자 저장해줄 변수
        for (int i = 0; i < expression.length(); i++) {              // 연산식 길이만큼 반복
            String s = expression.substring(i, i + 1);
            if (s.equals("+") || s.equals("-") || s.equals("*")) {   // 자른 한 글자가 연산자이면
                op.add(s);                                                       // 연산자 list에 추가
                operand.add(Long.parseLong(tmp));               // 반복할 동안 저장해둔 피연산자를 피연산자 list에 추가
                tmp = "";                                                         // 변수 초기화
            } else {                                                                // 피연산자이면
                tmp += s;                                                       // String 변수에 저장
            }
        }
        // 연산자일 때마다 각각의 리스트에 저장했기 때문에
        // 마지막 피연산자는 추가되지 않았음으로 추가해줌
        operand.add(Long.parseLong((tmp)));
    }

    public void combinationOperators(ArrayList<String> arrayList, String[] oper, boolean[] isVisit) {  // 연산자 조합 메소드
        if (arrayList.size() == 3) {                                                                // 연산자를 담은 리스트 길이가 3이면 연산자 조합이 채워짐
            list.add(arrayList);                                                                     //  연산자 우선 순위 경우의 수 리스트에 담음
            return;
        } else {
            for (int i = 0; i < oper.length; i++) {                                          // 연산자 개수 3만큼 반복
                if (!isVisit[i]) {                                                                      // arrayList에 해당 연산자를 추가하지 않았다면
                    ArrayList<String> temp = new ArrayList<>(arrayList);    // 임의의 리스트에 arrayList 복사
                    temp.add(oper[i]);                                                          // 해당 연산자 추가
                    isVisit[i] = true;                                                              // 추가했으므로 true
                    combinationOperators(temp, oper, isVisit);                   // 모든 연산자를 조합하기 위해 재귀 호출
                    isVisit[i] = false;                                                            // 윗 줄에서 경우의 수 계산되어 list에 추가됐으므로 다시 false 처리
                }
            }
        }
    }

    public long calculation(List<String> listOp, List<Long> operand, List<String> op) {  // 수식 계산 메소드 (파라미터 : 우선 순위 지킬 연산자, 수식 연산자, 수식 피연산자)
        // remove 계산 위해 연산자, 피연산자 복사
        List<Long> cOperand = new ArrayList<>(operand);
        List<String> cOp  = new ArrayList<>(op);

        for (int i = 0; i < listOp.size(); i++) {                                                              // 연산자 개수만큼 반복 ( 항상 3 )
            String operation = listOp.get(i);                                                                // 우선 순위인 연산자 저장

            for (int j = 0; j < cOp.size(); j++) {                                                            // 수식 연산자만큼 반복하여 우선 순위인 연산자를 찾아 먼저 계산
                if (operation.equals(cOp.get(j))) {
                    long tmp = calc(cOperand.get(j), cOperand.get(j + 1), operation);   // 연산자와 해당 위치의 피연산자 두개랑 수식 계산

                    cOperand.remove(j+1);                                                      // 계산된 피연산자 두개와 연산자 리스트에서 제거
                    cOperand.remove(j);
                    cOp.remove(j);

                    cOperand.add(j, tmp);                                                                    // 계산한 결과를 다시 해당 위치에 추가
                    j--;                                                                                                // 수식 연산자 리스트가 비워질 때까지 반복문이 종료되면 안되므로
                }
            }
        }
        return Math.abs(cOperand.get(0));                                                           // 계산이 종료되면 피연산자 리스트에 숫자 하나만 남음, 0번째 값을 절댓값 계산하여 리턴
    }

    public Long calc(Long num1, Long num2, String op) {    // 기호에 따라 단순 수식 계산 메소드
        long num = 0;
        switch (op) {                                                             // 연산자에 따라 입력받은 두 수를 계산
            case "+" -> num = num1 + num2;
            case "-" -> num = num1 - num2;
            case "*" -> num = num1 * num2;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution67257 solution67257 = new Solution67257();
        System.out.println(solution67257.solution("100-200*300-500+20"));
//        System.out.println(solution67257.solution("50*6-3*2"));
    }
}
