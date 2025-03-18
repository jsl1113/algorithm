package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class B1092_배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> crane = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        int m = Integer.parseInt(br.readLine());
        List<Integer> box = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        crane.sort(Comparator.reverseOrder());
        box.sort(Comparator.reverseOrder());

        int answer = 0;
        if (box.get(0) > crane.get(0)) {
            System.out.println(-1);
            return;
        }

        while (!box.isEmpty()) {
            answer++;

            for (Integer c : crane) {
                for (int i = 0; i < box.size(); i++) {
                    if (c >= box.get(i)) {
                        box.remove(i);
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
