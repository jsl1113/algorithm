package com.example.javaproject3.psstudy;

import java.util.*;

public class Solution64064 {
    HashSet<HashSet<String>> list = new HashSet<>();  // 제제 아이디 목록 경우의 수 저장
    public int solution(String[] user_id, String[] banned_id) {
        list = new HashSet<>();
        permutationID(new LinkedHashSet<>(), user_id, banned_id); // 데이터 추가한 순서대로 저장하기 위해 LinkedHashSet
        return list.size();
    }

    public void permutationID(HashSet<String> hs, String[] user_id, String[] banned_id){
        if (hs.size() == banned_id.length) {  //  불량 사용자 목록 길이와 사용자 아이디의 경우의 수 hashset 사이즈가 같을 때
            if(isBan(hs, banned_id)) list.add(new HashSet<>(hs)); // 불량 사용자 목록과 사용자 아이디 목록이 같다면 list에 저장
            return;
        }
        for (String id : user_id) { // 사용자 아이디를 하나씩 판단하여 경우의 수 조합
            if(!hs.contains(id)){ // hashset 에 해당 아이디가 포함되어 있지 않다면
                hs.add(id); // 해당 아이디 추가
                permutationID(hs, user_id, banned_id);  // 재귀로 호출하여 해당 아이디를 포함하는 경우의 수 판단
                hs.remove(id);  // 해당 아이디 제거
            }
        }
    }

    public boolean isBan(HashSet<String> hs, String[] banned_id) { //  해당 경우의 수가 불량 사용자 목록인지 확인하는 메소드
        int idx = 0;
        for(String userID : hs){
            String banID = banned_id[idx++];
            if (userID.length() == banID.length()) {  // 사용자 아이디 길이와 불량 사용자 아이디의 길이가 같다면
                for (int i = 0; i < banID.length(); i++) {
                    if(banID.charAt(i) != '*' && userID.charAt(i) != banID.charAt(i))  // 해당 index 값이 '*' 이 아니고 user id 와 ban id 의 해당 index 값이 다르면
                        return false;  // false 리턴
                 }
            } else return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution64064 solution64064 = new Solution64064();
        System.out.println(solution64064.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }
}
