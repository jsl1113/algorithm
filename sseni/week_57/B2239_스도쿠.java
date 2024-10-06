package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2239_스도쿠 {
    static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        if (sudoku()) {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    System.out.print(arr[row][col]);
                }
                System.out.println();
            }
        }
    }

    static boolean sudoku() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (arr[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(row, col, num)) {
                            arr[row][col] = num;

                            if (sudoku()) return true;
                            else arr[row][col] = 0;
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    // 숫자가 해당 위치에 유효한지 확인하는 함수
    static boolean isValid(int row, int col, int num) {
        for (int x = 0; x < 9; x++) {
            if (arr[row][x] == num) {
                return false;
            }
        }

        for (int x = 0; x < 9; x++) {
            if (arr[x][col] == num) {
                return false;
            }
        }

        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i + r][j + c] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
