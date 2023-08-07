package com.example.javaproject3.psstudy;

import java.util.HashSet;

public class Solution42577 {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        for(String phone : phone_book) set.add(phone); // phone 을 HashSet 에 저장

        for(String phone : phone_book){
            for(int i=1; i<phone.length(); i++){  // phone 길이마다
                if(set.contains(phone.substring(0, i)))  // set에 phone 으로 시작하는 값이 있는지 확인
                    return false;  // 있으면, false 리턴
            }
        }
        return true;
    }
}
