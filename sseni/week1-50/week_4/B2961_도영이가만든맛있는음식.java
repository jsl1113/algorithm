package com.example.algorithm.study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 문제를 보자마자 부분 집합을 구하는 문제가 떠오르고 비트마스킹이 생각났다.
// 비트마스킹으로 구하는 건 이제 잘 떠오른다. 뿌듯.
public class B2961 {
    public static class Ingredient {
        int s, b;

        public Ingredient(int s, int b) {
            this.s = s;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredients.add(new Ingredient(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < Math.pow(2, n); i++) {
            List<Ingredient> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) list.add(ingredients.get(j));
            }
            answer = Math.min(answer, cal(list));
        }

        System.out.println(answer);
    }

    public static int cal(List<Ingredient> list){
        int s = 1, b = 0;
        for (Ingredient ingredient : list) {
            s *= ingredient.s;
            b += ingredient.b;
        }

        return Math.abs(s - b);
    }
}
