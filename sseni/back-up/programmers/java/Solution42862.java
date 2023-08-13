package com.example.javaproject3.psstudy;

import java.util.HashSet;

public class Solution42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> ls = new HashSet<>();
        HashSet<Integer> rs = new HashSet<>();

        for (int r : reserve) rs.add(r);
        for (int l : lost) {
            if (rs.contains(l)) rs.remove(l); // 도난당한 학생은 여벌 옷을 입으면 되므로 hashset 에서 제거
            else ls.add(l);
        }
        for (int r : rs) { // 여벌 옷이 있는 학생 hashset 에서,
            // 앞 번호 학생 부터 확인하며 빌려야 가장 많은 학생이 빌릴 수 있음
            if (ls.contains(r - 1)) ls.remove(r - 1); // 앞 번호 학생이 여벌 옷이 있다면
            else if (ls.contains(r + 1)) ls.remove(r + 1); // 뒷 번호 학생이 여벌 옷이 있다면
        }
        return n - ls.size();  // 옷을 빌리지 못한 학생만 hashset 에 남아 있으므로, n - ls.size() 값 리턴
    }

    public static void main(String[] args) {
        System.out.println(new Solution42862().solution(5, new int[]{2,4}, new int[]{3}));
    }
}
