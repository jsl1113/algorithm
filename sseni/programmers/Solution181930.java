package com.example.javaproject3.pg;

public class Solution181930 {
    public int solution(int a, int b, int c) {
        if (a != b && b != c && c != a)  return a + b + c;
        if (a == b && b == c && c == a) return (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
         else return (a + b + c) * (a * a + b * b + c * c);
    }

    public static void main(String[] args) {

    }
}
