package com.example.javaproject3.psstudy;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution120886 {
    public int solution(String before, String after) {
        // 문자 배열을 스트림으로 변환하고 정렬 후 다시 join
        before = Stream.of(before.split("")).sorted().collect(Collectors.joining());
        after = Stream.of(after.split("")).sorted().collect(Collectors.joining());
        return before.equals(after) ? 1 : 0;
    }

    public int solution_(String before, String after) {
        char[] b = before.toCharArray();
        char[] a = after.toCharArray();
        Arrays.sort(b); Arrays.sort(a);
        return new String(b).equals(new String(a)) ? 1 : 0;
    }
}
