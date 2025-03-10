package com.example.algorithm.study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// n과 m 5,6은 오히려 금방 풀었는데 의외로 4가 원하는대로 답이 잘 나오지 않았다.
// 이전의 코드를 참고해서 풀었다.
// 다해놓고 헤맸던 것이었다. 40 line 에서 i 가 아니라 idx 를 넣고 계속 돌렸다.
// 이것도 재귀를 제대로 이해 못했다는 것이겠지 ㅜ
public class B15652 {
    static int n, m;
    static StringBuilder sb;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        list = new ArrayList<>();

        dfs(0,1);
        System.out.println(sb.toString());
    }

    public static void dfs(int cnt, int idx) {
        if (cnt == m) {
            for(int num : list) sb.append(num + " ");
            sb.append("\n");
            return;
        }

        for (int i = idx; i <= n; i++) {
            list.add(i);
            dfs(cnt + 1, i);
            list.remove(list.size() - 1);
        }
    }

}
