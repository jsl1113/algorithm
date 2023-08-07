package com.example.javaproject3.psstudy;

import java.util.*;

public class Solution87377 {
    private static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }


    List<Point> intersectionPoint = new ArrayList<>();
    public String[] solution(int[][] line) {
        // 1. 직선 별로 교점을 찾아 리스트에 저장
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                IntersectionPoint(line[i], line[j]);
            }
        }

        // 2. 최소, 최대 point 찾기
        Long minX = Long.MAX_VALUE;
        Long minY = Long.MAX_VALUE;
        Long maxX = Long.MIN_VALUE;
        Long maxY = Long.MIN_VALUE;

        for (Point p : intersectionPoint) {  // 교점 중 최소, 최대 x, y 값 찾기
            minX = Math.min(minX, p.x);
            minY = Math.min(minY, p.y);
            maxX = Math.max(maxX, p.x);
            maxY = Math.max(maxY, p.y);
        }

        // 3. 출력 형태 변환
        String[] answer = new String[(int) (maxY - minY + 1)];  // height
        boolean[][] board = new boolean[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];  // height, width

//        int idx = 0;
//        for (long i = minY; i <= maxY; i++) {
//            StringBuilder sb = new StringBuilder();
//            for (long j = minX; j <= maxX; j++) {
//                for(Point p : intersectionPoint){
//                    if(new Point(i, j).equals(p)){
//                        sb.append("*");
//                    } else sb.append(".");
//                }
//            }
//            arr[idx++] = sb.toString();
//        }
//        List<String> list = Arrays.asList(arr);
//        Collections.reverse(list);
//        String[] answer = list.toArray(arr);

        for (Point p : intersectionPoint) {
            int x = (int) (p.x - minX);
            int y = (int) (maxY - p.y);
            board[y][x] = true;
        }

        int i = 0;
        for (boolean[] booleans : board) {
            StringBuilder sb = new StringBuilder();
            for (boolean b : booleans) {
                if (b) sb.append("*");
                else sb.append(".");
            }
            answer[i++] = sb.toString();
        }
        return answer;
    }

    public void IntersectionPoint(int[] line1, int[] line2) {  // line1 = A B E, line2 = C D F
        long denominator = (long) line1[0] * (long) line2[1] - (long) line1[1] * (long) line2[0];

        if (denominator != 0) {  // ad - bc = 0 인 경우
            long numX = (long) line1[1] * (long) line2[2] - (long) line1[2] * (long) line2[1];
            long numY = (long) line1[2] * (long) line2[0] - (long) line1[0] * (long) line2[2];

            double x = (double) numX / (double) denominator;
            double y = (double) numY / (double) denominator;

            if (x % 1 == 0 && y % 1 == 0)  // 교점이 정수면 리턴
                intersectionPoint.add(new Point((long) x, (long) y));
        }
    }

    public static void main(String[] args) {
        Solution87377 solution87377 = new Solution87377();
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        String[] s = solution87377.solution(line);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
//        solution87377.IntersectionPoint(new int[]{2, -1, 4}, new int[]{-2, -1, 4});
    }

}
