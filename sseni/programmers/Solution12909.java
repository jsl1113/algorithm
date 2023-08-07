package com.example.javaproject3.pg;

public class Solution12909 {
    boolean solution(String brackets) {
        while (brackets.indexOf("()") != -1) {
            String[] split = brackets.split("\\(\\)");
            brackets = String.join("", split);
        }
        return brackets.length() == 0;
    }
}
