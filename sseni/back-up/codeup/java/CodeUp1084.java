package com.example.javaproject3.codeup;

import java.io.*;

public class CodeUp1084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");

        int r = Integer.parseInt(s[0]);
        int g = Integer.parseInt(s[1]);
        int b = Integer.parseInt(s[2]);
        int cnt = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<g; j++){
                for(int k=0; k<b;k++){
                    bw.write(i + " " + j + " " + k + "\n");
                    cnt++;
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
