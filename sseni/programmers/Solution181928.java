package com.example.javaproject3.pg;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution181928 {
    public int solution(int[] num_list) {
        String even = "", odd = "";
        for(int num : num_list){
            if(num %2 == 0) even += num;
            else odd += num;
        }
        return Integer.parseInt(odd) + Integer.parseInt(even);
    }
    public int solution1(int[] num_list) {
        int answer = 0;
        int odd = 0, even = 0;
        for(int num : num_list){
            if(num % 2 == 0) {
                even *= 10;
                even += num;
            }
            else {
                odd *= 10;
                odd += num;
            }
        }
        return odd + even;
    }

    public static void main(String[] args) {

    }
}
