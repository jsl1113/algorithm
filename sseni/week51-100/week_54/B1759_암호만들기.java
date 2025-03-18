package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1759_암호만들기 {
    static int L, C;
    static char[] arr;
    static boolean[] visited;
    static List<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        visited = new boolean[C];
        answer = new ArrayList<>();

        dfs(0, 0);

        StringBuilder sb = new StringBuilder();
        for (String s : answer) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int start, int cnt) {
        if (cnt == L) {
            if (check()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < C; i++) {
                    if (visited[i]) {
                        sb.append(arr[i]);
                    }
                }
                answer.add(sb.toString());
            }
            return;
        }

        for (int i = start; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }

    static boolean check() {
        int a = 0, b = 0;

        for (int i = 0; i < C; i++) {
            if (visited[i]) {
                if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') a++;
                else b++;
            }
        }

        return a >= 1 && b >= 2;
    }
}
