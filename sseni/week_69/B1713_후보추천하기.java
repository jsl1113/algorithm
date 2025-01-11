package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1713_후보추천하기 {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new int[101];
        ArrayList<Student> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int student = Integer.parseInt(st.nextToken());
            boolean flag = false;

            for (Student s : list) {
                if (s.num == student) {
                    s.cnt++;
                    flag = true;
                    break;
                }
            }

            if(flag) continue;

            if (list.size() == n) {
                list.sort((s1, s2) -> {
                    if (s1.cnt == s2.cnt) return Integer.compare(s1.time, s2.time);
                    return Integer.compare(s1.cnt, s2.cnt);
                });
                list.remove(0);
            }

            list.add(new Student(student, 1, i));
        }

        list.sort((s1, s2) -> Integer.compare(s1.num, s2.num));
        for (Student s : list) {
            System.out.print(s.num + " ");
        }
    }

    static class Student {
        int num, cnt, time;

        Student(int num, int cnt, int time) {
            this.num = num;
            this.cnt = cnt;
            this.time = time;
        }
    }
}
