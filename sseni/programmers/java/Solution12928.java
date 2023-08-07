package com.example.javaproject3.pg;

public class Solution12928 {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++)
            if(n%i == 0)
                answer += i;
        return answer;
    }
}
