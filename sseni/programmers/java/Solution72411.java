package com.example.javaproject3.psstudy;

import java.util.*;

public class Solution72411 {
    public HashMap<String, Integer> map;  // <코스 요리 조합, 주문 횟수 >

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {  // 문자열 오름차순 정렬 ( ex. WXA 같은 경우 위해 )
            char[] charArr = orders[i].toCharArray();  // 문자형 배열로 변환하여
            Arrays.sort(charArr);  // 정렬
            orders[i] = String.valueOf(charArr);  // 다시 문자열로 변환해 저장
        }

        for (int c : course) {  // 코스의 길이 만큼 조합을 구함
            map = new HashMap<>();  // 조합 수 카운팅
            int max = 0;

            for (String order : orders) {  // 각 주문마다 조합 탐색
                StringBuilder sb = new StringBuilder();  // 주문 조합할 StringBuilder 변수 선언
                if (c <= order.length())  // 탐색할 코스 요리 개수보다 주문한 요리 개수가 더 클 때
                    combination(order, sb, 0, 0, c);  // 조합을 구하는 메소드 호출
            }

            for (String key : map.keySet())  // map 의 코스 조합 ketSet 을 반복하여 가장 많이 주문된 횟수 탐색
                max = Math.max(max, map.get(key));  // key 에 따른 value 값과 max 값 중 큰 값을 max 에 저장

            for (String key : map.keySet()) {  // 최소 2번 이상 주문된 조합이고 가장 많이 주문한 횟수와 일치하는 조합은 Arraylist 에 추가
                int value = map.get(key);  // 코스 조합에 따른 주문 횟수 값
                if(value > 1 && max == value) answer.add(key);
            }
        }

        Collections.sort(answer);  // 코스 요리 조합 Arraylist 정렬
        return answer.toArray(new String[answer.size()]);  // String 배열로 변환하여 리턴
    }

    // str : 주문 메뉴 구성
    // sb : 조합을 구할 StringBuilder
    // idx : 조합할 때 주문 메뉴를 위한 index
    // cnt : 코스 요리 개수 카운트
    // n : 코스 요리 개수
    public void combination(String str, StringBuilder sb, int idx, int cnt, int n) {
        if (cnt == n)  //  코스 요리 개수만큼 조합이 되면
            map.put(sb.toString(), map.containsKey(sb.toString()) ? map.get(sb.toString()) + 1 : 1);  // map 에 해당 조합이 있으면  기존 주문 횟수에 +1, 없으면 1로 map에 저장
        else {
            for (int i = idx; i < str.length(); i++) {  // idx부터 시작해서 조합을 구함
                sb.append(str.charAt(i)); // sb 에 주문 메뉴 한 문자씩 붙여나감
                combination(str, sb, i + 1, cnt + 1, n);  // 재귀 호출
                sb.delete(cnt, cnt + 1);  // 해당 요리에 대한 조합은 계산되었기 때문에 sb 에 붙였던 요리 메뉴 삭제
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Solution72411 solution72411 = new Solution72411();
        System.out.println(Arrays.toString(solution72411.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
    }
}
