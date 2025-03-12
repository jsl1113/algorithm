package com.example.algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B20922_겹치는건싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        int answer = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            hm.put(arr[end], hm.getOrDefault(arr[end], 0) + 1);

            while (hm.get(arr[end]) > k) {
                hm.put(arr[start], hm.get(arr[start]) - 1);
                if (hm.get(arr[start]) == 0) {
                    hm.remove(arr[start]);
                }
                start++;
            }

            answer = Math.max(answer, end - start + 1);
        }

        System.out.println(answer);
    }
}
