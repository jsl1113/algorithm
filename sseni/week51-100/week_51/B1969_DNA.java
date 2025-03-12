package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1969_DNA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] strArray = new String[n];
        for (int i = 0; i < n; i++) {
            strArray[i] = br.readLine();
        }

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int max = Integer.MIN_VALUE;
            int idx = 0;

            int[] arr = new int[4];
            for (int j = 0; j < n; j++) {
                if(strArray[j].charAt(i) == 'A') arr[0]++;
                else if(strArray[j].charAt(i) == 'C') arr[1]++;
                else if(strArray[j].charAt(i) == 'G') arr[2]++;
                else arr[3]++;
            }

            for (int j = 0; j < 4; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    idx = j;
                }
            }

            switch (idx){
                case 0 -> sb.append("A");
                case 1 -> sb.append("C");
                case 2 -> sb.append("G");
                case 3 -> sb.append("T");
            }

            for (int j = 0; j < 4; j++) {
                if(j != idx) sum += arr[j];
            }
        }

        System.out.println(sb);
        System.out.println(sum);
    }
}
