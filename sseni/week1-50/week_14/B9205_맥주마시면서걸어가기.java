package com.example.algorithm.study.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 모든 점에 대한 거리를 계산하는 플로이드워샬 이용
public class B9205_맥주마시면서걸어가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            List<Point> list = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new Point(x, y));
            }

            boolean[][]  isVisited = new boolean[n + 2][n + 2];
            for (int i = 0; i < n + 2; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    int dis = Math.abs(list.get(i).x - list.get(j).x) + Math.abs(list.get(i).y - list.get(j).y);
                    if (dis <= 1000) {
                        isVisited[i][j] = true;
                        isVisited[j][i] = true;
                    }
                }
            }

            for (int k = 0; k < n + 2; k++) {
                for (int i = 0; i < n + 2; i++) {
                    for (int j = 0; j < n + 2; j++) {
                        if (isVisited[i][k] && isVisited[k][j]) {
                            isVisited[i][j] = true;
                        }
                    }
                }
            }

            sb.append((isVisited[0][n + 1] ? "happy" : "sad")).append("\n");
        }

        System.out.println(sb);
    }

     static class Point {
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
