package com.example.algorithm.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RV_B3107_IPv6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if(s.endsWith("::")) {
            s += "0";
        }

        String[] strArray = s.split("::");
        String[] arr = new String[8];
        Arrays.fill(arr, "");

        if (strArray.length == 1) {
            arr = strArray[0].split(":");
        } else {
            String[] a = strArray[0].split(":");
            String[] b = strArray[1].split(":");

            for (int i = 0; i < a.length; i++) {
                arr[i] = a[i];
            }

            for (int i = 0; i < b.length; i++) {
                arr[7 - i] = b[b.length - i - 1];
            }
        }

        for (int i = 0; i < 8; i++) {
            while (arr[i].length() < 4) {
                arr[i] = "0" + arr[i];
            }
        }

        for (int i = 0; i < 8; i++) {
            System.out.print(arr[i] + (i < 7 ? ":" : ""));
        }
    }
}
