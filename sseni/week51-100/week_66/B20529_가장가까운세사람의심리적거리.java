package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20529_가장가까운세사람의심리적거리  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            String[] arr = new String[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                arr[i] = st.nextToken();
            }

            if(n > 32) {
                System.out.println(0);
                continue;
            }

            int min = Integer.MAX_VALUE;
            for (int k = 0; k < n; k++) {
                for (int i = k + 1; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        min = Math.min(min, getDistance(arr[k], arr[i], arr[j]));
                        if(min == 0) break;
                    }
                }
            }

            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }

    static int getDistance(String s1, String s2, String s3) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += s1.charAt(i) != s2.charAt(i) ? 1 : 0;
            result += s2.charAt(i) != s3.charAt(i) ? 1 : 0;
            result += s1.charAt(i) != s3.charAt(i) ? 1 : 0;
        }
        return result;
    }
}
