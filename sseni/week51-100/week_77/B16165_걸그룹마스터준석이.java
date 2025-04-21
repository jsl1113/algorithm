package com.example.algorithm;

import java.io.*;
import java.util.*;

public class B16165_걸그룹마스터준석이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, List<String>> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int num = Integer.parseInt(br.readLine());

            List<String> list = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                list.add(br.readLine());
            }

            Collections.sort(list);
            hm.put(str, list);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String query = br.readLine();
            int type = Integer.parseInt(br.readLine());

            if (type == 0) {
                for (String member : hm.get(query)) {
                    sb.append(member).append("\n");
                }
            } else {
                for (Map.Entry<String, List<String>> entry : hm.entrySet()) {
                    if (entry.getValue().contains(query)) {
                        sb.append(entry.getKey()).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.print(sb);
    }
}
