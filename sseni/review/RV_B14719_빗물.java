package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RV_B14719_빗물 {
    static int h, w, arr[], max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = (max < arr[i]) ? arr[i] : max;
        }

        int height = 0, water = 0, answer = 0;
        for (int i = 0; i < w; i++) {
            if (height > arr[i]) {
                water += (height - arr[i]);
            } else {
                answer += water;
                height = arr[i];
                water = 0;
            }
        }

        height = 0;
        water = 0;
        for (int i = w - 1; i >= 0; i--) {
            if (height > arr[i]) {
                water += (height - arr[i]);
            } else {
                answer += water;
                height = arr[i];
                water = 0;
            }

            if(arr[i] == max) break;
        }

        System.out.println(answer);
    }
}
