package com.example.javaproject3.psstudy;


import java.lang.reflect.Array;
import java.util.*;

public class Solution72412 {
    // ex. {"javabackendjuniorpizza" : {100, 80, 70}} 이런 식으로 저장되어 있음
    static HashMap<String, List<Integer>> hm = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (String in : info)
            combination("", 0, in.split(" ")); // 지원자 정보를 분리한 후 조합 메소드 호출

        for (String key : hm.keySet()) // 점수 정렬
            Collections.sort(hm.get(key));

        for (int i = 0; i < query.length; i++) {  // 점수 조건 탐색 위해 이분 탐색
            String[] tmp = query[i].replaceAll(" and ", "").split(" ");  // and 를 없애고 [조건, 점수] 배열로 분리
            answer[i] = hm.containsKey(tmp[0]) ? binarySearch(tmp[0], Integer.parseInt(tmp[1])) : 0; // hashmap 에 있으면 이분 탐색 메소드 호출해서 점수 저장, 없으면 0 저장
        }
        return answer;
    }

    public int binarySearch(String str, int score) {  // str 과 점수로 이분 탐색
        System.out.println(Arrays.toString(new List[]{hm.get(str)}));
        List<Integer> list = hm.get(str);
        int left = 0, right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < score)  // 해당 지원자의 점수보다 score 가 크다면
                left = mid + 1;  // mid 이전의 지원자 점수는 해당하지 않음
            else right = mid - 1;
        }
        return list.size() - left;  // str 에 해당하는 점수의 총 개수에서 점수보다 크거나 같은 left 뺀 값 (지원자 수) 리턴
    }

    public void combination(String str, int len, String[] arr) {
        if (len == 4) {
            if (!hm.containsKey(str)) {  // str 이 hashmap 에 포함되어 있지 않으면
                hm.put(str, new ArrayList<>());
            }
            hm.get(str).add(Integer.parseInt(arr[4])); // str 에 해당하는 지원자 점수 hashmap 에 추가
            return;
        }
        combination(str + "-", len + 1, arr);  // 조건을 고려하지 않은 경우의 재귀 호출
        combination(str + arr[len], len + 1, arr); // 조건을 고려하는 경우의 재귀 호출

    }

    public static void main(String[] args) {
        Solution72412 solution72412 = new Solution72412();
        solution72412.solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"}, new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});
    }
}
