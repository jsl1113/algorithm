package com.example.javaproject3.psstudy;

public class Solution49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String skillTree : skill_trees){
            int idx = 0; // skill Index
            boolean isAnwer = true;
            for(char c : skillTree.toCharArray()){
                int skillTreeIdx = skill.indexOf(c);  // skill에서, skillTree 해당 문자가 위치하는 인덱스
                if(skillTreeIdx == -1) continue;  // 해당 문자가 skill에 없다는 의미
                else if(idx < skillTreeIdx) { // 이전에 배울 문자열이 존재, 불가능한 스킬 트리
                    isAnwer = false;
                    break;
                } else if(idx == skillTreeIdx) idx++;
            }
            if(isAnwer) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution49993().solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
