package com.example.algorithm.study;

import java.util.HashMap;

// 처음에 각 개수씩 곱하면 간단하게 나올거같은데? 하고 생각하긴 했는데 (안 입는 경우 +1 하는 걸 생각 못했음)
// 완탐인줄 알았다네 근데 짜면 짤수록, 수렁에 빠지는 느낌 ;;
// 결국 처음에 생각했던 곱하는 방식으로 더 생각해서 성공
public class P42578_의상 {
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (String[] strArray : clothes) {
            hm.put(strArray[1], hm.getOrDefault(strArray[1], 0) + 1);
        }

        int answer = 1;
        for (Integer cnt : hm.values()) {
            answer *= (cnt + 1);  // 의상x, 의상1, 의상2, 의상3 .. = cnt + 1
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}}));
//        System.out.println(solution(new String[][]{
//                {"crow_mask", "face"},
//                {"blue_sunglasses", "face"},
//                {"smoky_makeup", "face"}}));
    }
}
