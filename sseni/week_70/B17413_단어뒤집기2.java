package com.example.algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17413_단어뒤집기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);

            if (c == '<') {
                sb.append(tmp.reverse());
                tmp.setLength(0);
                while (i < str.length() && str.charAt(i) != '>') {
                    sb.append(str.charAt(i++));
                }
                sb.append('>');
                i++;
            } else if (c == ' ') {
                sb.append(tmp.reverse()).append(' ');
                tmp.setLength(0);
                i++;
            } else {
                tmp.append(c);
                i++;
            }
        }

        sb.append(tmp.reverse());
        System.out.println(sb);
    }
}
