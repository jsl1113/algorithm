package com.example.algorithm;

import java.io.*;
import java.util.*;


public class B1012_유기농배추 {
    public static int t, m, n, k, result;
    public static int map[][];  // r c
    public static boolean visit[][];
    public static int[] dr = { 1, -1, 0, 0 };
    public static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int c = 0; c < t; c++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[m][n];
            visit = new boolean[m][n];
            result = 0;

            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                map[p1][p2] = 1;
            }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j] == 1 && visit[i][j] == false){
                        bfs(i, j);
                        result++;
                    }
                }
            }
            sb.append(result + "\n");
        }
        System.out.println(sb.toString());
    }

    static void bfs(int x, int y){
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        while(!q.isEmpty()){
            x = q.peek().first();
            y = q.peek().second();
            q.poll();

            visit[x][y] = true;
            for(int i = 0; i < 4; i++){
                int r = x + dr[i];
                int c = y + dc[i];

                if(r >= 0 && c >= 0 && r < m && c < n){
                    if(visit[r][c] == false && map[r][c] == 1){
                        q.add(new Pair(r, c));
                        visit[r][c] = true;
                    }
                }
            }
        }
    }

    public static class Pair {
        Integer x, y;
        public Pair (Integer x, Integer y){
            this.x = x;
            this.y = y;
        }

        public Integer first(){ return x; }
        public Integer second() { return y; }
    }
}