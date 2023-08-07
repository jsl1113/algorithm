package com.example.javaproject3.psstudy;

import java.util.*;

public class Solution60060_ {

    public int[] solution(String[] words, String[] queries) {
        // 와일드카드가 접두사에 위치할 때 -> word와 query를 reverse 하면, 와일드카드가 접미사에 위치하는 문자열 비교와 같다.
        // <문자열 길이, 해당 길이의 문자열들의 List>
        Map<Integer, List<String>> fm = new HashMap<>();  // 와일드카드가 뒤에 있을 때
        Map<Integer, List<String>> bm = new HashMap<>(); // 와일드카드가 앞에 있을 때

        for(String word : words){  // 단어 배열의 값들을 map 에 저장
            fm.computeIfAbsent(word.length(), i -> new ArrayList<>()).add(word);
            bm.computeIfAbsent(word.length(), i -> new ArrayList<>()).add(new StringBuilder(word).reverse().toString());
        }

        for(int key : fm.keySet()){ // 해당 길이에 대한 문자열 리스트 정렬
            fm.get(key).sort(null);
            bm.get(key).sort(null);
        }

        List<Integer> result = new ArrayList<>();
        for(String query : queries){  // 검색 키워드 배열에 따라
            List<String> list;
            if(query.charAt(0) == '?'){  // 와일드카드가 접두사로 위치할 때
                list = bm.get(query.length()); // 해당 키워드 길이에 따른 문자열 리스트를 새로운 리스트에 저장
                query = new StringBuilder(query).reverse().toString(); // 퀴리 문자열을 reverse 하여 저장
            } else // 와일드카드가 접미사에 위치할 때
                list = fm.get(query.length());

            if(list == null) result.add(0);  // 리스트가 비어있을 경우, 0 저장
            else {
                result.add(
                        // ex. < frame, frodo, front, frost, kakao > 에서,
                        // (fro로 시작하지 않는 문자열 위치 인덱스) - (fro로 시작하는 문자열 위치 인덱스) 값이 매치된 단어의 개수와 같음
                        // fro** 인 경우 kakao의 위치 = 4,
                        // fro 인 경우, frodo의 위치 = 1 반환됨
                        lowerBound(list, query.replace("?", "z"))
                                - lowerBound(list, query.replace("?", "a"))
                );
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    // 문자열 리스트에서 쿼리 문자열이 들어갈 위치를 찾는 이분 탐색 메소드
    public static int lowerBound(List<String> list, String query){
        int start = 0; int end = list.size();

        while (start < end){
            int mid = (start + end) / 2;
            // compareTo 에서,
            // 비교 대상이 포함되어 있을 경우, 서로 문자열 길이의 차이를 반환
            // 포함되어 있지 않을 경우, 비교가 불가능한 지점의 아스키코드의 차가 반환됨
            // MAX - ascii("n") > 0, ascii("") - ascii("n") < 0
            if(query.compareTo(list.get(mid)) <= 0)
                end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution60060_().solution(
                new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"fro??", "????o", "fr???", "fro???", "pro?"}))
        );
    }
}
